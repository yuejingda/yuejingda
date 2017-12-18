package com.gys.domain;

import java.io.Serializable;
import java.util.List;

public class PageInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<? extends Object> rows;
	private Integer total;
	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageInfo(List<? extends Object> rows, Integer total) {
		super();
		this.rows = rows;
		this.total = total;
	}
	public List<? extends Object> getRows() {
		return rows;
	}
	public void setRows(List<? extends Object> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
}
