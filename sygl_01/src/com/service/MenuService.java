package com.service;

import java.util.List;

import com.dao.MenuDao;
import com.domain.Menu;

public class MenuService {
   
	MenuDao dao = new MenuDao();
	//----------------查找所有的menu----------------------
	public List<Menu> findMenuAll(){
		return dao.findMenuAll();
	}
	//---------------保存--------------------------------
	public void saveMenu(Menu menu){
		dao.save(menu);
	}
	//---------------查找rno对应的菜单----------------------
	public List<Menu> findMenusByRole(int rno){
		return dao.findMenusByRole(rno);
	}
	//---------------保存角色菜单关系----------------------
	public void saveRoleMenus(int rno,int[] mnos){
		dao.deleteRelationshipByRole(rno);
		for(int mno:mnos){
			dao.saveRelationshio(mno, rno);
		}
	}
	//--------------登录菜单----------------------------
	public List<Menu> findMenusByUser(int uno){
		return dao.findMenusByUser(uno);
	}
	//------------修改菜单---------------------------
	public Menu findMenuByMno(int mno){
		return dao.findMenuByMno(mno);
	}
	
	public void updateMenu(Menu menu){
		dao.updateMenu(menu);
	}
	//---------------------删除菜单-----------------------
	public void deleteMenu(int mno){
			dao.deleteMenu(mno);
	}
}
