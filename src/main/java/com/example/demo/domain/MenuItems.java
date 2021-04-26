package com.example.demo.domain;

// will hold items 

public class MenuItems {
	
	String foodName;
	double price;
	
	public MenuItems() {
		// TODO Auto-generated constructor stub
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MenuItems [foodName=" + foodName + ", price=" + price + "]";
	}
}
