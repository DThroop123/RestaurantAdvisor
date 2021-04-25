package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.SumRestaurantDAO;
import com.example.demo.domain.SumRestaurant;

@Component
public class SumRestaurantService {
	
	@Autowired
	SumRestaurantDAO sRDAO;
	
	public List<SumRestaurant> getSumRestaurantList() {
		
		return sRDAO.getSumRestList() ;
		
	}
	
	
	
	

}
