package com.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.impl.CarDaoImpl;
import com.domain.Car;
import com.service.ICarService;
@Service
public class CarServiceImpl implements ICarService{
	@Autowired
	private CarDaoImpl dao;
	
	@Override
	@Transactional(isolation=Isolation.SERIALIZABLE,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(List<Car> cars) {
		for(Car car : cars){
			dao.save(car);
		}
	}
	
}
