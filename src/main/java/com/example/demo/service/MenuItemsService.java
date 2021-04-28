package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MenuItemsDAO;
import com.example.demo.domain.MenuItems;

@Component
public class MenuItemsService {
	
	
	@Autowired
	MenuItemsDAO miDAO;
	
	public List<MenuItems> getMenuItemsList(String rname) {
		
//		System.out.println("I am in service rname=" + rname);
		
		return miDAO.getMenuItemsList(rname) ;
		
	}
	

}
