package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.domain.Review;
import com.example.demo.domain.SumRestaurant;
import com.example.demo.service.SumRestaurantService;
import com.example.demo.service.ReviewService;

// Controller for dynamic pages in the orders page 

@Controller
public class ReviewsController {
	
		@Autowired
		SumRestaurantService sumRestService;
		@Autowired 
		ReviewService     reviewService;

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
		public String restaurantMenuDisplay(HttpServletRequest request, Model model, @ModelAttribute Review review) {
			
			
			// retrieve name of restaurant from HTTP request	
			String rname = request.getParameter("rname");
			

			model.addAttribute("review", review);
			model.addAttribute("restOrder", rname);
			
			return "reviewForm";

		}
		
//		insert review
		@RequestMapping(value = "/submitReview", method = RequestMethod.POST)
		public String orderSubmissionDisplay(@ModelAttribute("review") Review review, Model model, SessionStatus status, HttpServletRequest request) {
			System.out.println("I am in the submitReview controller");

			HttpSession session = request.getSession(true);
			review.setCustEmail(session.getAttribute("email").toString());
			
			Integer restID = sumRestService.getRestID(review.getRestName().toString());
			
			review.setRestID(restID);

			reviewService.createReview(review);

			return "reviewSubmission";

		}
		
		
		

}