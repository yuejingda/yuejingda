package com.domain;

import java.io.Serializable;


public class Role1 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer rno;
	private String rname;
	private String rms;
	
	public Role1() {
		super();
	}

	public Role1(Integer rno, String rname, String rms) {
		super();
		this.rno = rno;
		this.rname = rname;
		this.rms = rms;
	}

	public Integer getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRms() {
		return rms;
	}

	public void setRms(String rms) {
		this.rms = rms;
	}
	
	
	
}
