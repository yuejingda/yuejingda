package com.service;

import java.util.List;

import com.dao.RoleDao;
import com.domain.Role1;

public class RoleService {
		
	RoleDao dao = new RoleDao();
	//--------------------���role�б�--------------------------
	public List<Role1> findRoleAll(){
		return dao.findRoleAll();
	}
	//-------------------����----------------------------------
	public void roleSave(Role1 role){
		dao.save(role);
	}
	//------------------�༭-----------------------------------
	public Role1 findRoleByRno(int rno){
		return dao.findRoleByRno(rno);
	}
	//-----------------�޸�------------------------------------
	public void roleUpdate(Role1 role){
		dao.update(role);
	}
	//-------------------ɾ��----------------------------------
	public void roleDelete(int rno){
		dao.delete(rno);
	}
	//--------------------����ɾ��------------------------------
	public void roleBatchDelete(int[] rnos){
		for(int rno : rnos){
			dao.delete(rno);
		}
	}
	//---------------------����uno�ҵ���Ӧroles---------------------
	public List<Role1> findRolesByUno(int uno){
		return dao.findRolesByUno(uno);
	}
	//---------------------�����û���ɫ-----------------------------
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

































