package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	 
	@RequestMapping(value = "/displayUsers", method = RequestMethod.GET)
	public String formExampleDisplay(HttpServletRequest request, Model model) {
		System.out.println("I am in displayUsers inside User Controller");

		//session access and print-out
		HttpSession session = request.getSession(true);
		String userName = session.getAttribute("user").toString();
		System.out.println("username from session: " + userName);

		// database query
		List<User> userList = new ArrayList<User>();

		//EmployeeService empService = new EmployeeService();
		userList = userService.getUserList();
		
		for (User e : userList)
			System.out.println(e);		
		
		model.addAttribute("empList",userList);	
		
		return "displayUsers";
	}
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute User user, Model model) {
		
		System.out.println("I am in saveUser inside User Controller");
		
		System.out.println("Employee details in saveUser" + user);
		

		userService.saveUser(user);
		
		model.addAttribute("employee", user);
		model.addAttribute("dnoList",getDnumbers());
		model.addAttribute("message","Update Successful");		

		
		return "editUser";
	}

	
	
	@RequestMapping(value = "/editUser/{email}", method = RequestMethod.GET)
	public String editUser(@PathVariable String email, @ModelAttribute User user, Model model) {

		System.out.println("I am in editUser inside User Controller");
		
		// database query
		// mvc 
		
		user = new User();
		user.setEmail(email);
		
		model.addAttribute("user",user);
		model.addAttribute("dnoList",getDnumbers());
		model.addAttribute("message","Please update user");
	
		
		return "editUser";
	}
	
	public ArrayList<String> getDnumbers() {
		ArrayList<String> dnoList = new ArrayList<String>();
		dnoList.add("1");
		dnoList.add("4");
		dnoList.add("5");
		dnoList.add("6");	
		
		return dnoList;
	}
	

}