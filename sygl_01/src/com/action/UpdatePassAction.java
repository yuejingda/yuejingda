package com.action;

import javax.servlet.http.HttpSession;

import org.xiudun.mvc.NeedSession;

import com.domain.User1;
import com.service.UserService;

public class UpdatePassAction implements NeedSession{
	private HttpSession session;
	private String newPass;
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	@Override
	public void needSession(HttpSession arg0) {
		session = arg0;
	}
	
	public void updatePass(){
		User1 user = (User1) session.getAttribute("user");
		new UserService().updatePass(newPass, user.getUno());
	}
	
	public String obtainUpass(){
		User1 user = (User1) session.getAttribute("user");
		return user.getUpass();
	}
	
}
