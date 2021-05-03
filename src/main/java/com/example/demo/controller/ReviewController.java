package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.MenuItems;
import com.example.demo.domain.SumRestaurant;
import com.example.demo.service.MenuItemsService;
import com.example.demo.service.SumRestaurantService;

// Controller for dynamic pages in the orders page 

@Controller
public class ReviewController {
	
		@Autowired
		SumRestaurantService sumRestService;
		@Autowired 
		MenuItemsService     menuItemsService;

		// displays restaurants to be reviewed 
		@RequestMapping(value = "/reviews", method = RequestMethod.GET)
		public String restaurantOrderDisplay(Model model) {
			
			// database query	
			List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
			sumRest = sumRestService.getSumRestaurantList();
			
			// add list to model
			model.addAttribute("sumRestList", sumRest);
			
			return "Reviews";

		}
		
		

		// displays menu items from specified restaurant 
		@RequestMapping(value = "/submitReview", method = RequestMethod.GET)
		public String restaurantMenuDisplay(HttpServletRequest request, Model model) {
			
			// retrieve name of restaurant from HTTP request	
			String rname = request.getParameter("rname");
			
			// database query
			
			model.addAttribute("restOrder", rname);
			
			return "reviewForm";

		}
		
//		 inserts + confirms order
		@RequestMapping(value = "/submitReview", method = RequestMethod.POST)
		public String orderSubmissionDisplay(HttpServletRequest request, Model model) {
			
			
			
		
			return "reviewSubmission";

		}
		
		
		

}
