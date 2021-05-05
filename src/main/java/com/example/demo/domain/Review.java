package com.example.demo.domain;

 

public class Review {
	
	double reviewId;
	String custEmail;
	String restName;
	String reviewTitle;
	String reviewDescr;
	String reviewDate; //might need to change from string value
	double rating;
	Integer restID;
	
	
	public Review() {
		
	}
	
	public Review(double reviewId, String custEmail, String restName, String reviewTitle, String reviewDescr,
			String reviewDate, double rating, Integer restID) {
		super();
		this.reviewId = reviewId;
		this.custEmail = custEmail;
		this.restName = restName;
		this.reviewTitle = reviewTitle;
		this.reviewDescr = reviewDescr;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.restID = restID;
	}

	public double getReviewId() {
		return reviewId;
	}
	public void setReviewId(double reviewId) {
		this.reviewId = reviewId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewDescr() {
		return reviewDescr;
	}
	public void setReviewDescr(String reviewDescr) {
		this.reviewDescr = reviewDescr;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public Integer getRestID() {
		return restID;
	}

	public void setRestID(Integer restID) {
		this.restID = restID;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", custEmail=" + custEmail + ", restName=" + restName + ", reviewTitle="
				+ reviewTitle + ", reviewDescr=" + reviewDescr + ", reviewDate=" + reviewDate + ", rating=" + rating
				+ ", restID=" + restID + "]";
	}

	
	
	
	
	
}
