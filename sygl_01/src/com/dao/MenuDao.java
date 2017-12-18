package com.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.domain.Menu;

public class MenuDao extends BaseDao {
	
	
	//----------------查找所有记录-------------------------
	public List<Menu> findMenuAll(){
		String sql = "select * from t_menu";
		return this.getJdbcInterface().selectForObjects(sql, Menu.class);
	}
	//-----------------保存--------------------------------
	public void save(Menu menu){
		String sql = "insert into t_menu values(null,?,?,?,null)";
		this.jdbcInterface.insert(sql, menu.getMname(),menu.getHref(),menu.getPno());
	}
	//----------------找到rno对应的菜单----------------------
	public List<Menu> findMenusByRole(int rno){
		String sql = "select * from t_menu where mno in (select mno from t_role1_menu where rno=?)";
		return this.jdbcInterface.selectForObjects(sql, Menu.class, rno);
	}
	//--------------保存角色菜单关系--------------------------
	//删除原有关系
	public void deleteRelationshipByRole(int rno){
		String sql ="delete from t_role1_menu where rno=?";
		this.jdbcInterface.delete(sql, rno);
	}
	//保存新的关系
	public void saveRelationshio(int mno,int rno){
		String sql ="insert into t_role1_menu values (null,?,?,null)";
		this.jdbcInterface.insert(sql, mno,rno);
	}
	//--------------------------找到登录用户的所有menu-----------------------
	public List<Menu> findMenusByUser(int uno){
		String sql = "select * from t_menu where mno in(select mno from t_role1_menu where rno in (select rno from user1_role1 where uno=?) )";
		return this.jdbcInterface.selectForObjects(sql, Menu.class, uno);
	}
	//------------------------修改menu------------------------------------
	public Menu findMenuByMno(int mno){
		String sql = "select * from t_menu where mno = ?";
		return this.jdbcInterface.selectForObject(sql,Menu.class, mno);
	}
	public void updateMenu(Menu menu){
		String sql = "update t_menu set mname=?,href=? where mno=?";
		this.jdbcInterface.update(sql, menu.getMname(),menu.getHref(),menu.getMno());
	}
	//--------------------------删除菜单-------------------------
	public void deleteMenu(int mno){
		String sql = "delete from t_menu where mno=?";
		this.jdbcInterface.delete(sql, mno);
	}
}

























