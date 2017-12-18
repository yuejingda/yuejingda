package com.domain;

import java.io.Serializable;

public class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cno;
	private String cname;
	private String color;
	private Integer price;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(Integer cno, String cname, String color, Integer price) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.color = color;
		this.price = price;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
