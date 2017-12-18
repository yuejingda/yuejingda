package com.action;

import javax.servlet.http.HttpSession;

import org.xiudun.mvc.NeedSession;

public class LogoutAction implements NeedSession{
	private HttpSession session;
	@Override
	public void needSession(HttpSession arg0) {
		session = arg0;
		
	}
	
	public String logout(){
		session.invalidate();
		return "logout";
	}

}
