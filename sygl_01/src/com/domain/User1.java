package com.domain;

import java.io.Serializable;

public class User1 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer uno;
	private String uname;
	private String upass;
	private String truename;
	private String flag;
	
	public User1() {
		super();
	}

	public User1(Integer uno, String uname, String upass, String truename, String flag) {
		super();
		this.uno = uno;
		this.uname = uname;
		this.upass = upass;
		this.truename = truename;
		this.flag = flag;
	}

	public Integer getUno() {
		return uno;
	}

	public void setUno(int uno) {
		this.uno = uno;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
}
