package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.MenuItems;


@Component
public class MenuItemsDAO {
		
		@Autowired
		private MenuItemsMapper muMapper;
		
		public List<MenuItems> getMenuItemsList(String rname) {
			
//			System.out.println("I am in DAO rname=" + rname);
			
			List<MenuItems> menuItemsList = new ArrayList<MenuItems>();
				
			menuItemsList = muMapper.getMenuItemsList(rname);
			
			return menuItemsList;
		}


}
