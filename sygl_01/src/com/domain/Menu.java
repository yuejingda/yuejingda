package com.domain;

import java.io.Serializable;

public class Menu implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer mno;
	private String mname;
	private String href;
	private Integer pno;
	public Menu() {
		super();
	}
	
	public Menu(Integer mno, String mname, String href, Integer pno) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.href = href;
		this.pno = pno;
	}

	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}
	
}
