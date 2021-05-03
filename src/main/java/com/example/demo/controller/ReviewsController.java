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

import com.example.demo.domain.MenuItems;
import com.example.demo.domain.SumRestaurant;
import com.example.demo.domain.User;
import com.example.demo.service.SumRestaurantService;
import com.example.demo.service.UserService;

@Controller
public class ReviewsController {
	
	@Autowired
	SumRestaurantService sumRestService;

	@RequestMapping(value = "/reviews", method = RequestMethod.GET)
	public String RestaurantReviewsDisplay(Model model) {

		List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
		sumRest = sumRestService.getSumRestaurantList();
		
		// add list to model
		model.addAttribute("sumRestList", sumRest);

		return "Reviews";
	}
	
	@RequestMapping(value = "/displayUserReviews", method = RequestMethod.GET)
	public String usersReviewDisplay(HttpServletRequest request, Model model) {
		
		// retrieve name of restaurant from HTTP request	
		String rname = request.getParameter("rname");
		
		// database query
		List<ReviewList> reviewList = new ArrayList<ReviewList>();
		menuItems = menuItemsService.getMenuItemsList(rname);
		
		// add list to model
		model.addAttribute("menuItems", menuItems);	
		model.addAttribute("restOrder", rname);
		
		return "Menu";

	}

	

}