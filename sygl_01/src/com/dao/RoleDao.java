package com.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.domain.Role1;

public class RoleDao extends BaseDao{
	
	
	//-------------------查找所有的role信息---------------------
	public List<Role1> findRoleAll(){
		String sql = "select * from role1";
		return this.jdbcInterface.selectForObjects(sql, Role1.class);
	}
	//-------------------添加----------------------------------
	public void save(Role1 role){
		String sql ="insert into role1 (rname,rms) values (?,?)";
		this.jdbcInterface.insert(sql, role.getRname(),role.getRms());
	}
	//------------------编辑------------------------------------
	public Role1 findRoleByRno(int rno){
		String sql="select * from role1 where rno=?";
		return this.jdbcInterface.selectForObject(sql, Role1.class, rno);
	}
	//------------------修改------------------------------------
	public void update(Role1 role){
		String sql = "update role1 set rname=?,rms=? where rno=?";
		this.jdbcInterface.update(sql, role.getRname(),role.getRms(),role.getRno());
	}
	//------------------删除------------------------------------
	public void delete(int rno){
		String sql = "delete from role1 where rno=?";
		this.jdbcInterface.delete(sql, rno);
	}
	//-------------------根据uno找到相应的roles---------------------
	public List<Role1> findRolesByUno(int uno){
		String sql = "select * from role1 where rno in (select rno from user1_role1 where uno=?)";
		return this.jdbcInterface.selectForObjects(sql, Role1.class, uno);
	}
	//-------------------删除原来的关系----------------------------
	public void deleteRelationshipByUser(int uno){
		String sql = "delete from user1_role1 where uno=?";
		this.jdbcInterface.delete(sql, uno);
	}
	//------------------从新保存用户角色关系-------------------------
	public void saveRelationshipByUser(int uno,int rno){
		String sql = "insert into user1_role1 values(null,?,?)";
		this.jdbcInterface.insert(sql, uno,rno);
	}
}











