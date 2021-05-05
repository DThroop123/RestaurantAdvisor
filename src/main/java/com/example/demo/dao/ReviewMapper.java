package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Review;

@Mapper
public interface ReviewMapper {
	
	@Insert("insert INTO CUST_REVIEW (ReviewID, custEmail, restID, reviewTitle, reviewDescr, reviewDate, rating) values(Customer_ReviewId_Seq.nextval, #{custEmail}, #{restID}, #{reviewTitle}, #{reviewDescr}, sysdate, #{rating})")
	void insertReview(Review review);	
}
