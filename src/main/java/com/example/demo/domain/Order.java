package com.example.demo.domain;

import java.util.Arrays;

// object to be mapped too from menu page

public class Order {
	
	String[] orderQuant;
	String[] fnames;
	String medium;
	String rname;
	Integer orderID;
	String custEmail;
	
	public Order() {
		
		// TODO Auto-generated constructor stub
	}

	public Order(String[] orderQuant, String[] fnames, String medium, String rname, Integer orderID, String custEmail) {
		super();
		this.orderQuant = orderQuant;
		this.fnames = fnames;
		this.medium = medium;
		this.rname = rname;
		this.orderID = orderID;
		this.custEmail = custEmail;
	}

	public String[] getOrderQuant() {
		return orderQuant;
	}

	public void setOrderQuant(String[] orderQuant) {
		this.orderQuant = orderQuant;
	}

	public String[] getFnames() {
		return fnames;
	}

	public void setFnames(String[] fnames) {
		this.fnames = fnames;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	@Override
	public String toString() {
		return "Order [orderQuant=" + Arrays.toString(orderQuant) + ", fnames=" + Arrays.toString(fnames) + ", medium="
				+ medium + ", rname=" + rname + ", orderID=" + orderID + ", custEmail=" + custEmail + "]";
	}
	

}
