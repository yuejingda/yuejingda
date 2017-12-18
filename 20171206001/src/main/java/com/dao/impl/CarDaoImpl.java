package com.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ICarDao;
import com.domain.Car;

@Repository
public class CarDaoImpl extends SqlSessionDaoSupport implements ICarDao{
	@Autowired
	public void setFactory(SqlSessionFactory factory){
		super.setSqlSessionFactory(factory);
	}
	
	@Override
	public void save(Car car) {
		SqlSession session = this.getSqlSession();
		session.insert("com.dao.ICarDao.save",car);
	}

}
