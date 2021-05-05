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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.SumRestaurant;
import com.example.demo.domain.User;
import com.example.demo.service.SumRestaurantService;

@Controller
public class RestaurantsController {

	@Autowired
	SumRestaurantService sumRestService;

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	public String restaurantsDisplay(Model model) {

		List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
		sumRest = sumRestService.getSumRestaurantList();

		model.addAttribute("sumRestList", sumRest);

		return "Restaurants";
	}

	// search function
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam(name = "searchVal", required = false) String searchVal, Model model) {
		System.out.println("I am in search aux function");

		String viewPage = "searchResult", searchResultMsg = "Restaurant not found";

		List<SumRestaurant> sumRest = new ArrayList<SumRestaurant>();
		List<String> restNames = new ArrayList<String>();

		sumRest = sumRestService.getSumRestaurantList();
		for (var i = 0; i < sumRest.size(); i++) {
			restNames.add(i, sumRest.get(i).getrName());
		}

		var nameIndex = restNames.indexOf(searchVal);

		if (nameIndex != -1) {
			searchResultMsg = "";
			model.addAttribute("name", sumRest.get(nameIndex).getrName());
			model.addAttribute("phone", sumRest.get(nameIndex).getPhone());
			model.addAttribute("email", sumRest.get(nameIndex).getEmail());
			model.addAttribute("hours", sumRest.get(nameIndex).getHours());
			model.addAttribute("diningType", sumRest.get(nameIndex).getDiningType());
			model.addAttribute("city", sumRest.get(nameIndex).getCity());
			model.addAttribute("state", sumRest.get(nameIndex).getState());
			model.addAttribute("priceRange", sumRest.get(nameIndex).getPriceRange());
			model.addAttribute("deliveryFlag", sumRest.get(nameIndex).getDeliveryFlag());
			model.addAttribute("stNo", sumRest.get(nameIndex).getStreetNo());
			model.addAttribute("stName", sumRest.get(nameIndex).getStreetName());
			model.addAttribute("zip", sumRest.get(nameIndex).getZip());
			model.addAttribute("outDoorSeatingFlag", sumRest.get(nameIndex).getOutDoorSeatingFlag());
		}
		
		model.addAttribute("searchResultMsg", searchResultMsg);
		return viewPage;
	}

}
