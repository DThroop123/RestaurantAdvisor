package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.domain.Order;

@Mapper
public interface orderMapper {
	
	@SelectKey(statement = "SELECT MAX(ONO) FROM RESTAURANT_ORDER", keyProperty = "orderID", before = true, resultType = int.class)
	@Insert("INSERT INTO RESTAURANT_ORDER VALUES (Restaurant_Order_Ono.nextval,sysdate,'dannyt@restaurantadvisor.com','Y','N','N',null,null,sysdate + interval '10' minute)")
	void insertOrder(Order order);

}
