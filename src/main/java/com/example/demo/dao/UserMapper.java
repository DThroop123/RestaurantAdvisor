package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.User;

@Mapper
public interface UserMapper {
	
	@Select("SELECT EMAIL, STNO, STNAME, CITY, STATE, ZIP, PASSWORD, PHONE, FNAME, MINIT, LNAME FROM CUSTOMER")
	List<User> getUserList();

	@Update("update CUSTOMER set fname = #{fname}, minit=#{minit}, lname=#{lname}, phone=#{phone} where email = #{email}")
	void saveUser(User user);
	
	@Insert("insert INTO CUSTOMER (email, stno, stname, city, state, zip, password, phone, fname, minit, lname) values(#{email}, #{stno}, #{stname}, #{city}, #{state}, #{zip}, #{password}, #{phone}, #{fname}, #{minit}, #{lname})")
	void insertUser(User user);	
}