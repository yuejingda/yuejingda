package com.action;

import java.util.List;

import org.xiudun.mvc.ResponseBody;

import com.domain.Role1;
import com.service.RoleService;

public class RoleAction {
	private int rno;
	private int[] rnos;
	private List<Role1> roles;
	private Role1 role;
	private int uno;
	//-----------------���ղ���-------------------------------------
	public void setRole(Role1 role) {
		this.role = role;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setRnos(int[] rnos) {
		this.rnos = rnos;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	//-----------------���ݲ���-------------------------------------
	public List<Role1> getRoles() {
		return roles;
	}
	public Role1 getRole() {
		return role;
	}



	RoleService service = new RoleService();
	//---------------------��ʾ���е�role---------------------------
	public String roleShow(){
		roles = service.findRoleAll();
		return "roleShow";
	}
	//---------------------����------------------------------------
	public String roleSave(){
		service.roleSave(role);
		return "roleSave";
	}
	//-------------------�༭--------------------------------------
	public String roleEdit(){
		role = service.findRoleByRno(rno);
		return "roleEdit";
	}
	//------------------�޸�---------------------------------------
	public String roleUpdate(){
		service.roleUpdate(role);
		return "roleUpdate";
	}
	//-----------------ɾ��----------------------------------------
	public String roleDelete(){
		service.roleDelete(rno);
		return "roleDelete";
	}
	//----------------����ɾ��-------------------------------------
	public String roleBatchDelete(){
		service.roleBatchDelete(rnos);
		return "roleBatchDelete";
	}
	//----------------������Ӧrole����-----------------------------------
	@ResponseBody
	public String setRole(){
		 roles = service.findRoleAll();
		 StringBuilder json = new StringBuilder();
		 json.append("[");
		 for(Role1 role:roles){
			 json.append("{");
			 json.append("\"rno\":"+role.getRno()+",");
			 json.append("\"rname\":\""+role.getRname()+"\",");
			 json.append("\"rms\":\""+role.getRms()+"\"");
			 json.append("},");
		 }
		 json.delete(json.length()-1, json.length());
		 json.append("]");
		 
		 return json.toString();
	}
	//-----------------------�ҵ�uno��Ӧ��roles-------------------
	@ResponseBody
	public String setUserRole(){
		roles = service.findRolesByUno(uno);
		StringBuilder json = new StringBuilder();
		 json.append("[");
		 for(Role1 role:roles){
			 json.append("{");
			 json.append("\"rno\":"+role.getRno()+",");
			 json.append("\"rname\":\""+role.getRname()+"\",");
			 json.append("\"rms\":\""+role.getRms()+"\"");
			 json.append("},");
		 }
		 json.delete(json.length()-1, json.length());
		 json.append("]");
		 
		 return json.toString();
	} 
	//----------------------�����¹�ϵ--------------------------------
	@ResponseBody
	public String toSetRoles(){
		service.setRoles(uno, rnos);
		
		return "���óɹ�";
	}
	
}
































