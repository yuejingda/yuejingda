package com.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.domain.User1;

public class UserDao extends BaseDao {
	
	//--------------------��¼----------------------
	public User1 findByUnameAndUpass(String uname,String upass){
		String sql ="select * from user1 where uname=? and upass=?";
		User1 user1= this.getJdbcInterface().selectForObject(sql, User1.class,uname,upass);
		if(user1==null){
			return null;
		}
		return user1;
	}
	//-------------------����������Ϣ-------------------
	public List<User1> findUserAll(){
		String sql="select * from user1";
		return this.jdbcInterface.selectForObjects(sql,User1.class);
	}
	//-------------------����û���Ϣ---------------------
	public void save(User1 user){
		String sql = "insert into user1 (uname,upass,truename,flag) values (?,?,?,?)";
		this.jdbcInterface.insert(sql, user.getUname(),user.getUpass(),user.getTruename(),user.getFlag());
	}
	//--------------------����uno������Ӧuser-------------
	public User1 findUserByUno(int uno){
		String sql = "select * from user1 where uno=?";
		return this.jdbcInterface.selectForObject(sql, User1.class, uno);
	}
	//-----------------------�޸�-------------------------
	public void userUpdate(User1 user){
		String sql ="update user1 set uname=?,upass=?,truename=?,flag=? where uno=?";
		this.jdbcInterface.update(sql, user.getUname(),user.getUpass(),user.getTruename(),user.getFlag(),user.getUno());
	}
	//-----------------------ɾ���û���Ϣ------------------
	public void userDelete(int uno){
		String sql = "delete from user1 where uno=?";
		this.jdbcInterface.delete(sql, uno);
	}
	//---------------------�޸�����-----------------------
	public void updateUpass(String upass,int uno){
		String sql = "update user1 set upass=? where uno=?";
		this.jdbcInterface.update(sql, upass,uno);
	}
	
}






















