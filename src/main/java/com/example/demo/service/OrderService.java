package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.OrderDAO;
import com.example.demo.domain.Order;



@Component
public class OrderService {
	
	@Autowired 
	OrderDAO oDAO;

	public void insertOrder(Order order) {
		
		oDAO.insertOrder(order);
		
	}

}
