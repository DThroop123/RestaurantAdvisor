package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.SumRestaurant;

@Component
public class SumRestaurantDAO {
	
	@Autowired
	private SumRestaurantMapper restMapper;
	
	public List<SumRestaurant> getSumRestList() {
		
		List<SumRestaurant> sumRestList = new ArrayList<SumRestaurant>();
			
		sumRestList = restMapper.getSumRestList();
		
		return sumRestList;
	}


}
