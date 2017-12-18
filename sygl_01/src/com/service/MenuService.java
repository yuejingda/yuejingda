package com.service;

import java.util.List;

import com.dao.MenuDao;
import com.domain.Menu;

public class MenuService {
   
	MenuDao dao = new MenuDao();
	//----------------�������е�menu----------------------
	public List<Menu> findMenuAll(){
		return dao.findMenuAll();
	}
	//---------------����--------------------------------
	public void saveMenu(Menu menu){
		dao.save(menu);
	}
	//---------------����rno��Ӧ�Ĳ˵�----------------------
	public List<Menu> findMenusByRole(int rno){
		return dao.findMenusByRole(rno);
	}
	//---------------�����ɫ�˵���ϵ----------------------
	public void saveRoleMenus(int rno,int[] mnos){
		dao.deleteRelationshipByRole(rno);
		for(int mno:mnos){
			dao.saveRelationshio(mno, rno);
		}
	}
	//--------------��¼�˵�----------------------------
	public List<Menu> findMenusByUser(int uno){
		return dao.findMenusByUser(uno);
	}
	//------------�޸Ĳ˵�---------------------------
	public Menu findMenuByMno(int mno){
		return dao.findMenuByMno(mno);
	}
	
	public void updateMenu(Menu menu){
		dao.updateMenu(menu);
	}
	//---------------------ɾ���˵�-----------------------
	public void deleteMenu(int mno){
			dao.deleteMenu(mno);
	}
}
