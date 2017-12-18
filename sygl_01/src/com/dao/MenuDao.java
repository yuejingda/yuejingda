package com.dao;

import java.util.List;

import org.xiudun.jdbc.BaseDao;

import com.domain.Menu;

public class MenuDao extends BaseDao {
	
	
	//----------------�������м�¼-------------------------
	public List<Menu> findMenuAll(){
		String sql = "select * from t_menu";
		return this.getJdbcInterface().selectForObjects(sql, Menu.class);
	}
	//-----------------����--------------------------------
	public void save(Menu menu){
		String sql = "insert into t_menu values(null,?,?,?,null)";
		this.jdbcInterface.insert(sql, menu.getMname(),menu.getHref(),menu.getPno());
	}
	//----------------�ҵ�rno��Ӧ�Ĳ˵�----------------------
	public List<Menu> findMenusByRole(int rno){
		String sql = "select * from t_menu where mno in (select mno from t_role1_menu where rno=?)";
		return this.jdbcInterface.selectForObjects(sql, Menu.class, rno);
	}
	//--------------�����ɫ�˵���ϵ--------------------------
	//ɾ��ԭ�й�ϵ
	public void deleteRelationshipByRole(int rno){
		String sql ="delete from t_role1_menu where rno=?";
		this.jdbcInterface.delete(sql, rno);
	}
	//�����µĹ�ϵ
	public void saveRelationshio(int mno,int rno){
		String sql ="insert into t_role1_menu values (null,?,?,null)";
		this.jdbcInterface.insert(sql, mno,rno);
	}
	//--------------------------�ҵ���¼�û�������menu-----------------------
	public List<Menu> findMenusByUser(int uno){
		String sql = "select * from t_menu where mno in(select mno from t_role1_menu where rno in (select rno from user1_role1 where uno=?) )";
		return this.jdbcInterface.selectForObjects(sql, Menu.class, uno);
	}
	//------------------------�޸�menu------------------------------------
	public Menu findMenuByMno(int mno){
		String sql = "select * from t_menu where mno = ?";
		return this.jdbcInterface.selectForObject(sql,Menu.class, mno);
	}
	public void updateMenu(Menu menu){
		String sql = "update t_menu set mname=?,href=? where mno=?";
		this.jdbcInterface.update(sql, menu.getMname(),menu.getHref(),menu.getMno());
	}
	//--------------------------ɾ���˵�-------------------------
	public void deleteMenu(int mno){
		String sql = "delete from t_menu where mno=?";
		this.jdbcInterface.delete(sql, mno);
	}
}

























