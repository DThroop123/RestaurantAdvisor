package com.example.demo.domain;

// displays partial information about the user

public class User {
	
	String email;
	String stNo;
	String stName;
	String city;
	String state;
	String zip;
	String password;
	String phone;
	String fname;
	String mInit;
	String lname;
	
	
	public User(String email, String stNo, String stName, String city, String state, String zip, String password, String phone,
			String fname, String mInit, String lname) {
		super();
		this.email = email;
		this.stNo = stNo;
		this.stName = stName;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.password = password;
		this.phone = phone;
		this.fname = fname;
		this.mInit = mInit;
		this.lname = lname;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStno() {
		return stNo;
	}
	public void setStno(String stNo) {
		this.stNo = stNo;
	}
	public String getStname() {
		return stName;
	}
	public void setStname(String stName) {
		this.stName = stName;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMinit() {
		return mInit;
	}
	public void setMinit(String mInit) {
		this.mInit = mInit;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	@Override
	public String toString() {
		return "User [email=" + email + ", stNo=" + stNo + ", stName=" + stName + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", password=" + password + ", phone=" + phone
				+ ", fname=" + fname + ", mInit=" + mInit + ", lname=" + lname + "]";
	}

}
