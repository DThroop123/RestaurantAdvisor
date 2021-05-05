package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ReviewDAO;
import com.example.demo.domain.Review;

@Component
public class ReviewService {

@Autowired
ReviewDAO reviewDAO;

	public void createReview(Review review) {
//		UserDAO userDAO = new UserDAO();
		reviewDAO.createReview(review);
	}
}	