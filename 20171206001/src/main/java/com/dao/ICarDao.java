package com.dao;

import org.apache.ibatis.annotations.Insert;

import com.domain.Car;

public interface ICarDao  {
	
	@Insert("insert into t_car values(#{cno},#{cname},#{color},#{price})")
	public void save(Car car);
}
