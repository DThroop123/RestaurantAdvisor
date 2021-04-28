package com.example.demo.domain;

// displays partial information about the restaurant

public class SumRestaurant {
	
	String rName;
	String phone;
	String email;
	String hours;
	String diningType;
	String city;
	String state;
	String priceRange;
	String deliveryFlag;
	String stNo;
	String stName;
	String zip;
	String outDoorFlag;
	
	public SumRestaurant(String rName, String phone, String email, String hours, String diningType, String city,
			String state, String priceRange, String deliveryFlag, String stNo, String stName, String zip, String outDoorFlag) {
		super();
		this.rName = rName;
		this.phone = phone;
		this.email = email;
		this.hours = hours;
		this.diningType = diningType;
		this.city = city;
		this.state = state;
		this.priceRange = priceRange;
		this.deliveryFlag = deliveryFlag;
		this.stNo = stNo;
		this.stName = stName;
		this.zip = zip;
		this.outDoorFlag = outDoorFlag;
	}
	
	public SumRestaurant() {
		// TODO Auto-generated constructor stub
	}

	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getDiningType() {
		return diningType;
	}
	public void setDiningType(String diningType) {
		this.diningType = diningType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	public String getDeliveryFlag() {
		return deliveryFlag;
	}
	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}
	public String getStreetNo() {
		return stNo;
	}
	public void setStreetNo(String stNo) {
		this.stNo = stNo;
	}
	public String getStreetName() {
		return stName;
	}
	public void setStreetName(String stName) {
		this.stName = stName;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getOutDoorFlag() {
		return outDoorFlag;
	}
	public void setOutDoorFlag(String outDoorFlag) {
		this.outDoorFlag = outDoorFlag;
	}
	
	
	@Override
	public String toString() {
		return "SumRestaurant [rName=" + rName + ", phone=" + phone + ", email=" + email + ", hours=" + hours
				+ ", diningType=" + diningType + ", city=" + city + ", state=" + state + ", priceRange=" + priceRange
				+ ", deliveryFlag=" + deliveryFlag + ", stNo=" + stNo + ", stName=" + stName + ", zip=" + zip + ", outDoorFlag=" + outDoorFlag + "]";
	}


}
