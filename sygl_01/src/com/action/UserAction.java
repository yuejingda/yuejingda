package com.action;


import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.xiudun.mvc.NeedRequest;

import com.domain.User1;
import com.service.UserService;

public class UserAction implements NeedRequest {
	
	private InputStream[] is;
	private InputStream files;
	private int uno;
	private int[] unos;
	private String uname;
	private String upass;
	private HttpServletRequest request;
	private User1 user;
	private List<User1> users;
	//private List<File> files;
	//--------------------获取参数-------------------
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public void setUser(User1 user) {
		this.user = user;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	
	public void setUnos(int[] unos) {
		this.unos = unos;
	}
	public void setIs(InputStream[] is) {
		this.is = is;
	}
	
	public void setFiles(InputStream ip) {
		this.files = ip;
	}
	@Override
	public void needRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	//-----------------------传递下一请求需要的参数--------------
	public User1 getUser() {
		return user;
	}
	public List<User1> getUsers() {
		return users;
	}
	public HttpServletRequest getRequest() {
		return request;
	}

	
	
	UserService service = new UserService();
	//----------------------登录---------------------------
	public String checkLogin(){
		 user = service.checkLogin(uname, upass);
		if(user==null){
			return "login";
		}else {
			if(user.getFlag().equals("2")){
				
				return "disabled";
			}else{
				request.getSession().setAttribute("user", user);
				return "main";
			}
		}
	}
	//-------------------显示所有用户---------------------
	public String userShow(){
		users = service.findUserAll();
		return "userShow";
	}
	//-------------------添加用户-------------------------
	public String userSave(){
		service.save(user);
		return "userSave";
	}
	//------------------编辑------------------------------
	public String userEdit(){
		user = service.findUserByUno(uno);
		return "userEdit";
	}
	
	//------------------修改-----------------------------
	public String userUpdate(){
		service.userUpdate(user);
		return "userUpdate";
	}
	//-----------------删除------------------------------
	public String userDelete(){
		service.userDelete(uno);
		return "userDelete";
	}
	//-----------------批量删除---------------------------
	public String userBatchDelete(){
		service.userBatchDelete(unos);
		return "userBatchDelete";
	}
	//-----------------导入excel------------------------
	public String userUpload(){
		try{
			Integer n = null;
			//for(InputStream s : is){
				Workbook book = WorkbookFactory.create(files);
				Sheet sheet = book.getSheetAt(0);
				for(int i=1;i<=sheet.getLastRowNum();i++){
					//-----------------得到行-----------------
					Row row = sheet.getRow(i);
					//得到列
					Cell c1 = row.getCell(0);
					Cell c2 = row.getCell(1);
					Cell c3 = row.getCell(2);
					Cell c4 = row.getCell(3);
					String uname = c1.getStringCellValue();
					String upass = (int)c2.getNumericCellValue()+"";
					String truename = c3.getStringCellValue();
					String flag = (int)c4.getNumericCellValue()+"";
					user = new User1(n,uname,upass,truename,flag);
					service.save(user);
				}
			//}
			return "userUpload";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "fail";
	}
	
	

}
