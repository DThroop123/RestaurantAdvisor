package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.SumRestaurant;
import com.example.demo.service.SumRestaurantService;

// Controller for dynamic pages in the orders page 

@Controller
public class RestaurantsController {

	@Autowired
	SumRestaurantService sumRestService;

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public String restaurantsDisplay(Model model) {
		
		List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
		sumRest = sumRestService.getSumRestaurantList();
<<<<<<< HEAD
		
=======
			
>>>>>>> main
		model.addAttribute("sumRestList", sumRest);
		
		return "Restaurants";

	}

}
