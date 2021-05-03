package com.example.demo.domain;

 

public class UserReviews {
	
	double reviewId;
	String custEmail;
	String reviewTitle;
	String reviewDescr;
	String reviewDate; //might need to change from string value
	double rating;
	
	
	public UserReviews() {
		
	}
	public UserReviews(double reviewId, String custEmail, String reviewTitle, String reviewDescr, String reviewDate,
			double rating) {
		super();
		this.reviewId = reviewId;
		this.custEmail = custEmail;
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
		return "UserReviews [reviewId=" + reviewId + ", custEmail=" + custEmail + ", reviewTitle=" + reviewTitle
				+ ", reviewDescr=" + reviewDescr + ", reviewDate=" + reviewDate + ", rating=" + rating + "]";
	}
	
	
}
