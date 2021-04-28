package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.SumRestaurant;

@Mapper
public interface SumRestaurantMapper {
	
	@Select("SELECT RNAME, PHONE, EMAIL, HOURS, DININGTYPE, CITY, STATE, PRICERANGE, DELIVERYFLAG, STREETNO, STREETNAME, ZIP, OUTDOORSEATINGFLAG FROM RESTAURANT")
	List<SumRestaurant> getSumRestList();

}
