package com.service;

import java.util.List;

import com.dao.RoleDao;
import com.domain.Role1;

public class RoleService {
		
	RoleDao dao = new RoleDao();
	//--------------------浏览role列表--------------------------
	public List<Role1> findRoleAll(){
		return dao.findRoleAll();
	}
	//-------------------保存----------------------------------
	public void roleSave(Role1 role){
		dao.save(role);
	}
	//------------------编辑-----------------------------------
	public Role1 findRoleByRno(int rno){
		return dao.findRoleByRno(rno);
	}
	//-----------------修改------------------------------------
	public void roleUpdate(Role1 role){
		dao.update(role);
	}
	//-------------------删除----------------------------------
	public void roleDelete(int rno){
		dao.delete(rno);
	}
	//--------------------批量删除------------------------------
	public void roleBatchDelete(int[] rnos){
		for(int rno : rnos){
			dao.delete(rno);
		}
	}
	//---------------------根据uno找到相应roles---------------------
	public List<Role1> findRolesByUno(int uno){
		return dao.findRolesByUno(uno);
	}
	//---------------------设置用户角色-----------------------------
	public void setRoles(int uno, int[] rnos){
		dao.deleteRelationshipByUser(uno);
		if(rnos==null || rnos.length==0){
			return ;
		}
		for(int rno:rnos){
			dao.saveRelationshipByUser(uno, rno);
		}
	}
}

































