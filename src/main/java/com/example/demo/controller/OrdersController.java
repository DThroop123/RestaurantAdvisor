package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.domain.MenuItems;
import com.example.demo.domain.Order;
import com.example.demo.domain.SumRestaurant;
import com.example.demo.service.MenuItemsService;
import com.example.demo.service.OrderService;
import com.example.demo.service.SumRestaurantService;

// Controller for dynamic pages in the orders page 

@Controller
@SessionAttributes("order")
public class OrdersController {

	@Autowired
	SumRestaurantService sumRestService;
	@Autowired
	MenuItemsService menuItemsService;
	@Autowired
	OrderService orderService;

	// displays restaurants to be ordered from
	@RequestMapping(value = "/displayOrders", method = RequestMethod.GET)
	public String restaurantOrderDisplay(Model model) {

		// database query
		List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
		sumRest = sumRestService.getSumRestaurantList();

		// add list to model
		model.addAttribute("sumRestList", sumRest);

		return "Orders";

	}

	// displays menu items from specified restaurant
	@RequestMapping(value = "/displayMenu", method = RequestMethod.GET)
	public String restaurantMenuDisplay(HttpServletRequest request, Model model) {

		// retrieve name of restaurant from HTTP request
		String rname = request.getParameter("rname");

		// database query
		List<MenuItems> menuItems = new ArrayList<MenuItems>();
		menuItems = menuItemsService.getMenuItemsList(rname);

		// variable to initialize order lists -> otherwise list is null
		int initialize = menuItems.size();

		// initialize foodName and quantity array
		String[] fNames = new String[initialize];
		String[] quant = new String[initialize];
		for (int j = 0; j < fNames.length; j++) {
			fNames[j] = "";
			quant[j] = "";
		}

		// this session's form with pre-filled values
		Order order = new Order(quant, fNames, "", "", "", rname, 0, "");
		
		// insert food names from menu and set order quantity too "0"
		for (int i = 0; i < menuItems.size(); i++) {
			order.getFnames()[i] = menuItems.get(i).getFoodName();
			order.getOrderQuant()[i] = "0";

		}

		// add elements to the model
		model.addAttribute("order", order);
		model.addAttribute("mediumList", getMedium());
		model.addAttribute("menuItems", menuItems);
		model.addAttribute("restOrder", rname);

		return "Menu";

	}

	// inserts + confirms order
	@RequestMapping(value = "/orderSubmission", method = RequestMethod.POST)
	public String orderSubmissionDisplay(@ModelAttribute("order") Order order, Model model, SessionStatus status,
			HttpServletRequest request) {

		// initializing variables
		int zeroCount = 0;
		Integer restID = sumRestService.getRestID(order.getRname().toString());
		Boolean negativeNum = false;
		// empty order error checking
		for (int i = 0; i < order.getOrderQuant().length; i++) {
			if (order.getOrderQuant()[i].equals("0")) {
				zeroCount++;
			}
			if(Integer.parseInt(order.getOrderQuant()[i]) < 0) {
				negativeNum = true;
			}
		}

		// order was empty --> return error page
		if (zeroCount == order.getOrderQuant().length) {

			return "emptyOrder";
		}
		
		//order had negative number, display error page
		if(negativeNum) {
			return "emptyOrder";
		}

		// determining the medium of the order and setting the correct flag
		if (order.getMedium().equals("Pickup")) {
			order.setpFlag("Y");
			order.setdFlag("N");
		} else {
			order.setpFlag("N");
			order.setdFlag("Y");
		}

		// set the currently logged in user to be the owner of the order
		HttpSession session = request.getSession(true);
		order.setCustEmail(session.getAttribute("email").toString());

		// insert order mapping into database table RESTAURANT_ORDER
		orderService.insertOrder(order);

		// insert each foodItem and its associated quantity into database table
		// RESTAURANT_ODETAILS
		for (int i = 0; i < order.getFnames().length; i++) {
			// if the quantity ordered does not equal 0 we want to insert it
			if (!(order.getOrderQuant()[i].equals("0"))) {
				orderService.insertOrderDetails(order.getOrderID(), order.getFnames()[i], restID,
						order.getOrderQuant()[i]);
			}
		}

		// insert oNo to be displayed back to user
		model.addAttribute("oNumber", order.getOrderID());
		// complete session status for order form
		status.setComplete();

		return "OrderSubmission";

	}

	// returns list of options for order medium
	public ArrayList<String> getMedium() {
		ArrayList<String> mediumList = new ArrayList<String>();
		mediumList.add("Pickup");
		mediumList.add("Delivery");

		return mediumList;
	}

}
