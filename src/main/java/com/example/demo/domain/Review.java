package com.example.demo.domain;

 

public class Review {
	
	double reviewId;
	String custEmail;
	double restID;
	String reviewTitle;
	String reviewDescr;
	String reviewDate; //might need to change from string value
	double rating;
	
	
	public Review() {
		
	}
	public Review(double reviewId, String custEmail, double restID, String reviewTitle, String reviewDescr, String reviewDate,
			double rating) {
		super();
		this.reviewId = reviewId;
		this.custEmail = custEmail;
		this.restID = restID;
		this.reviewTitle = reviewTitle;
		this.reviewDescr = reviewDescr;
		this.reviewDate = reviewDate;
		this.rating = rating;
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
	public double getRestID() {
		return restID;
	}
	public void setRestID(double restID) {
		this.restID = restID;
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
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", custEmail=" + custEmail + ", restID=" + restID + ", reviewTitle="
				+ reviewTitle + ", reviewDescr=" + reviewDescr + ", reviewDate=" + reviewDate + ", rating=" + rating
				+ "]";
	}
	
	
	
}
