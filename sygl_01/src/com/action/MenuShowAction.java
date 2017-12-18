package com.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.xiudun.mvc.NeedSession;
import org.xiudun.mvc.ResponseBody;

import com.domain.Menu;
import com.domain.User1;
import com.service.MenuService;

import net.sf.json.JSONArray;


public class MenuShowAction implements NeedSession{
	private List<Menu> menus;
	private Menu menu;
	private int rno;
	private int[] mnos;
	private HttpSession session;
	private int mno;
	
	//-------------------���ղ���--------------------
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setMnos(int[] mnos) {
		this.mnos = mnos;
	}
	@Override
	public void needSession(HttpSession arg0) {
		session = arg0;
		
	}
	//--------------------���ݲ���--------------------
	public List<Menu> getMenus() {
		return menus;
	}
	

	MenuService service = new MenuService();
	@ResponseBody
	public String menuShow(){
		menus = service.findMenuAll();
		//��װ��json����
		StringBuilder json = new StringBuilder();
		json.append("[");
		for(Menu menu:menus){
			json.append("{");
			json.append("\"mno\":\""+menu.getMno()+"\",");
			json.append("\"mname\":\""+menu.getMname()+"\",");
			json.append("\"href\":\""+menu.getHref()+"\",");
			json.append("\"pno\":\""+menu.getPno()+"\"");
			json.append("},");
		}
		json.delete(json.length()-1, json.length());
		json.append("]");
		return json.toString();
	}
	//----------------------����-----------------------
	public void saveMenu(){
		service.saveMenu(menu);
	}
	//---------------------���ҽ�ɫ��Ӧ�Ĳ˵�--------------
	@ResponseBody
	public String setMenus(){
		List<Menu> menus = service.findMenusByRole(rno);
		String json = JSONArray.fromObject(menus).toString();
		return json;
	}
	//-------------------�����ɫ�˵���ϵ------------------
	public void saveRoleMenus(){
		service.saveRoleMenus(rno, mnos);
	}
	//-----------------��¼�����ʾ�˵�----------------------
	@ResponseBody
	public String loginMenus(){
		User1 user = (User1) session.getAttribute("user");
		List<Menu> menus = service.findMenusByUser(user.getUno());
		String json = JSONArray.fromObject(menus).toString();
		return json;
	}
	//----------------------�޸Ĳ˵�------------------------
	@ResponseBody
	public String findMenuByMno(){
		Menu menu1 = service.findMenuByMno(mno);
		String json = JSONArray.fromObject(menu1).toString();
		return json;
	}
	public void updateMenu(){
		System.out.println(menu.getMname()+"++++++++s");
		service.updateMenu(menu);
	}
	
	//------------------------ɾ���˵�-----------------------------
	public void deleteMenu(){
		service.deleteMenu(mno);
	}
}




























