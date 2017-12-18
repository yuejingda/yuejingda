package com.service;

import java.util.List;

import com.dao.UserDao;
import com.domain.User1;

public class UserService {
	UserDao dao= new UserDao();
	//----------------------��¼-----------------------
	public User1 checkLogin(String uname,String upass){
		return dao.findByUnameAndUpass(uname, upass);
	}
	//---------------------����������Ϣ------------------
	public List<User1> findUserAll(){
		return dao.findUserAll();
	}
	//--------------------����û�-----------------------
	public void save(User1 user){
		dao.save(user);
	}
	//--------------------����uno������Ӧuser---------------
	public User1 findUserByUno(int uno){
		return dao.findUserByUno(uno);
	}
	//--------------------�޸�---------------------------
	public void userUpdate(User1 user){
		dao.userUpdate(user);
	}
	//--------------------ɾ��--------------------------
	public void userDelete(int uno){
		dao.userDelete(uno);
	}
	//--------------------����ɾ��-----------------------
	public void userBatchDelete(int[] unos){
		for(int uno:unos){
			dao.userDelete(uno);
		}
	}
	//------------------�û��޸�����----------------------
	public void updatePass(String upass,int uno){
		dao.updateUpass(upass, uno);
	}
}





















