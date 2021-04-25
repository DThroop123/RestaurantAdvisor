package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.SumRestaurant;
import com.example.demo.service.SumRestaurantService;

// Controller for dynamic pages in the orders page 

@Controller
public class OrdersController {
	
	@Autowired
	SumRestaurantService sumRestService;

		// displays restaurants to be ordered from 
		@RequestMapping(value = "/displayOrders", method = RequestMethod.GET)
		public String restaurantOrderDisplay(Model model) {
			
			// database query
			
			List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
			sumRest = sumRestService.getSumRestaurantList();
			
			// console test
//			for (SumRestaurant r : sumRest)
//				System.out.println(r);
//			
			model.addAttribute("sumRestList", sumRest);
			
			// we will eventually return this with data values filled in (restaurants to be ordered from)
			return "Orders";

		}
		

}
