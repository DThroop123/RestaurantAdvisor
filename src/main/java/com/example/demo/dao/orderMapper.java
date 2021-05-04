package com.example.demo.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.domain.Order;

@Mapper
public interface orderMapper {
	
	@SelectKey(statement = "SELECT MAX(ONO) FROM RESTAURANT_ORDER", keyProperty = "orderID", before = false, resultType = int.class)
	@Insert("INSERT INTO RESTAURANT_ORDER VALUES (Restaurant_Order_Ono.nextval,sysdate, #{custEmail},'N', #{dFlag}, #{pFlag}, null, null, sysdate + interval '10' minute)")
	void insertOrder(Order order);
	

	@Insert("INSERT INTO RESTAURANT_ODETAILS VALUES (#{orderID}, #{fname}, #{restID}, #{quantity})")
	void insertOrderDetails(@Param("orderID") Integer orderID, @Param("fname") String fname, @Param("restID") Integer restID, @Param("quantity") Integer quantity);

}
