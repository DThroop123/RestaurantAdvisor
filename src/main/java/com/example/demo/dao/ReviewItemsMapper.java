package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.MenuItems;

@Mapper
public interface ReviewItemsMapper {
	
	@Select("SELECT M.FOODNAME, M.PRICE FROM MENU M, RESTAURANT R WHERE R.RNAME = #{rname} AND R.RESTID = M.RESTID")
	List<MenuItems> getMenuItemsList(@Param("rname") String rname);

}