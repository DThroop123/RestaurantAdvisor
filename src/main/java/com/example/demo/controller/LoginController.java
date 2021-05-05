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

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/RestaurantLogin", method = RequestMethod.GET)
	public String userLogin(HttpServletRequest request, @ModelAttribute User user, Model model) {

		String viewPage = "RestaurantLogin", message = "";

		model.addAttribute("user", user);
		model.addAttribute("message", message);

		return viewPage;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome(HttpServletRequest request, Model model) {

		String viewPage = "Home", message = "";

		HttpSession session = request.getSession();
		var user = session.getAttribute("user");

		model.addAttribute("user", user);
		model.addAttribute("message", message);

		return viewPage;
	}

	// login user
	@RequestMapping(value = "/RestaurantLogin", method = RequestMethod.POST)
	public String loginUser(HttpServletRequest request, @ModelAttribute User user, Model model) {

		String viewPage = "", message = "";

		String email = user.getEmail();
		String password = user.getPassword();

		HttpSession session = request.getSession(true);

		List<User> userList = new ArrayList<User>();
		userList = userService.getUserList();
		int userIndex = -1;
		Boolean found = false;

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(email)) {
				found = true;
				if (userList.get(i).getPassword().equals(password)) {
					session.setAttribute("email", email);
					userIndex = i;
					viewPage = "home";
				} else {
					message = "Incorrect password";
					viewPage = "RestaurantLogin";
					user = new User();
				}
			}
		}
		if (!found) {
			viewPage = "RestaurantLogin";
			message = "User not found";
			user = new User();
		}

		if (userIndex > -1) {
			model.addAttribute("user", userList.get(userIndex));
			session.setAttribute("user", userList.get(userIndex));
		} else {
			model.addAttribute("user", user);
		}
		model.addAttribute("message", message);

		return viewPage;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String userLogout(HttpServletRequest request, @ModelAttribute User user, Model model) {

		String viewPage = "RestaurantLogin", message = "";
		HttpSession session = request.getSession(true);
		session.invalidate();

		model.addAttribute("user", user);
		model.addAttribute("message", message);

		return viewPage;
	}

	// get user registration page
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String userRegistration(HttpServletRequest request, @ModelAttribute User user, Model model) {

		String viewPage = "register", message = "Register as a new user";

		model.addAttribute("user", user);
		model.addAttribute("message", message);

		return viewPage;
	}

	// register new user
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request, @ModelAttribute User user, Model model) {

		System.out.println("I am in register inside login controller");
		String viewPage;

		// check if user already exists
		List<User> userList = new ArrayList<User>();
		userList = userService.getUserList();
		Boolean found = false;
		// check for email field filled in
		if (user.getEmail() == "") {
			// email field is required
			viewPage = "register";
			String errorMsg = "Email field is required";
			model.addAttribute("errorMsg", errorMsg);
			return viewPage;
		}

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getEmail().equals(user.getEmail())) {
				found = true;
			}
		}
		if (found) {
			// email is already in database
			viewPage = "register";
			String errorMsg = "Email is already associated with an account";
			model.addAttribute("errorMsg", errorMsg);
			return viewPage;
		}

		if (user.getFname() == "") {
			viewPage = "register";
			String errorMsg = "First name field cannot be empty";
			model.addAttribute("errorMsg", errorMsg);
			return viewPage;
		}
		
		if (user.getLname() == "") {
			viewPage = "register";
			String errorMsg = "Last name field cannot be empty";
			model.addAttribute("errorMsg", errorMsg);
			return viewPage;
		}
		
		if (user.getPassword() == "") {
			viewPage = "register";
			String errorMsg = "Password cannot be empty";
			model.addAttribute("errorMsg", errorMsg);
			return viewPage;
		}

		// register user
		userService.registerUser(user);

		HttpSession session = request.getSession(true);
		session.setAttribute("email", user.getEmail());

		viewPage = "home";
		String registrationMessage = "Registration Successful!";

		model.addAttribute("user", user);
		model.addAttribute("registrationMessage", registrationMessage);

		return viewPage;
	}

}