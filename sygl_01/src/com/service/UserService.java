package com.service;

import java.util.List;

import com.dao.UserDao;
import com.domain.User1;

public class UserService {
	UserDao dao= new UserDao();
	//----------------------登录-----------------------
	public User1 checkLogin(String uname,String upass){
		return dao.findByUnameAndUpass(uname, upass);
	}
	//---------------------查找所有信息------------------
	public List<User1> findUserAll(){
		return dao.findUserAll();
	}
	//--------------------添加用户-----------------------
	public void save(User1 user){
		dao.save(user);
	}
	//--------------------根据uno查找相应user---------------
	public User1 findUserByUno(int uno){
		return dao.findUserByUno(uno);
	}
	//--------------------修改---------------------------
	public void userUpdate(User1 user){
		dao.userUpdate(user);
	}
	//--------------------删除--------------------------
	public void userDelete(int uno){
		dao.userDelete(uno);
	}
	//--------------------批量删除-----------------------
	public void userBatchDelete(int[] unos){
		for(int uno:unos){
			dao.userDelete(uno);
		}
	}
	//------------------用户修改密码----------------------
	public void updatePass(String upass,int uno){
		dao.updateUpass(upass, uno);
	}
}





















