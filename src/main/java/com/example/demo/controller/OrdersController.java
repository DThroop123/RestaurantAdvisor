package com.example.demo.controller;

<<<<<<< HEAD
import java.awt.Menu;
=======

>>>>>>> main
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTMLDocument.Iterator;

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
		
		//initialize foodName and quantity array
		String[] fNames = new String[initialize];
		String[] quant = new String[initialize];
		for(int j = 0; j < fNames.length; j++)
		{
			fNames[j] = "";
			quant[j] = "";
		}
		
		// this session's form with pre-filled values
		
		Order order = new Order(quant, fNames, "", rname, 0);
		
		System.out.println(order.toString());
		
		for(int i = 0; i < menuItems.size(); i++)
		{
			order.getFnames()[i] = menuItems.get(i).getFoodName();
			order.getOrderQuant()[i] = "0";
			
		}
		
		System.out.println(order.toString());

		// add lists to model
		model.addAttribute("order", order);
		model.addAttribute("mediumList", getMedium());
		model.addAttribute("menuItems", menuItems);
		model.addAttribute("restOrder", rname);

		return "Menu";

	}

	// inserts + confirms order
	@RequestMapping(value = "/orderSubmission", method = RequestMethod.POST)
	public String orderSubmissionDisplay(@ModelAttribute("order") Order order, Model model, SessionStatus status) {

		// see the contents of the submission for testing
		System.out.println(order.toString());
		
		// insert order mapping into database table RESTAURANT_ORDER
		orderService.insertOrder(order);
		
		// insert each foodItem and its associated quantities
//		for(int i = 0; i < order.getFnames().length; i++)
//		{
//			orderService.insertOrderDetails(order.getFnames()[i], order.getOrderQuant()[i], order.getOrderID());
//		}
		
		// insert oNo to be displayed back to user 
		model.addAttribute("oNumber", order.getOrderID());
		
		status.setComplete();		
		return "submissionTest";

	}
	

	public ArrayList<String> getMedium() {
		ArrayList<String> mediumList = new ArrayList<String>();
		mediumList.add("Pickup");
		mediumList.add("Delivery");
		
		return mediumList;
	}
	
	

}
