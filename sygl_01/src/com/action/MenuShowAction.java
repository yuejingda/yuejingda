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
	
	//-------------------接收参数--------------------
	
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
	//--------------------传递参数--------------------
	public List<Menu> getMenus() {
		return menus;
	}
	

	MenuService service = new MenuService();
	@ResponseBody
	public String menuShow(){
		menus = service.findMenuAll();
		//组装成json对象
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
	//----------------------保存-----------------------
	public void saveMenu(){
		service.saveMenu(menu);
	}
	//---------------------查找角色对应的菜单--------------
	@ResponseBody
	public String setMenus(){
		List<Menu> menus = service.findMenusByRole(rno);
		String json = JSONArray.fromObject(menus).toString();
		return json;
	}
	//-------------------保存角色菜单关系------------------
	public void saveRoleMenus(){
		service.saveRoleMenus(rno, mnos);
	}
	//-----------------登录左侧显示菜单----------------------
	@ResponseBody
	public String loginMenus(){
		User1 user = (User1) session.getAttribute("user");
		List<Menu> menus = service.findMenusByUser(user.getUno());
		String json = JSONArray.fromObject(menus).toString();
		return json;
	}
	//----------------------修改菜单------------------------
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
	
	//------------------------删除菜单-----------------------------
	public void deleteMenu(){
		service.deleteMenu(mno);
	}
}




























