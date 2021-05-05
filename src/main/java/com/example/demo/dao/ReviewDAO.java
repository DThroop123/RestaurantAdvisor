package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Review;

@Component
public class ReviewDAO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	public void createReview(Review review) {
		reviewMapper.insertReview(review);
	}
}


//public List<Review> getReviewList() {
//
//	List<Review> reviewList = new ArrayList<Review>();
//
//	reviewList = reviewMapper.getReviewList();
//
//	return reviewList;
//}