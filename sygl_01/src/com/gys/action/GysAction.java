package com.gys.action;


import java.util.List;

import org.xiudun.mvc.ResponseBody;

import com.gys.domain.Gys;
import com.gys.domain.PageInfo;
import com.gys.service.GysService;

import net.sf.json.JSONObject;

public class GysAction {
	private int rows;
	private int page;
	private Gys gys;
	private int gysbh;
	private int[] gysbhs;
	private String gysmc;
	private String lxr;
	private String lxdh;
	private String frdb;
	private String gsdz;
	private String yb;
	private String cz;
	private String sjhm;
	private String yhzh;
	private String sh;
	private String khyh;
	private String bzxx;
	
	
	//---------------------接收参数----------------------------------
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setGysmc(String gysmc) {
		this.gysmc = gysmc;
	}
	public void setLxr(String lxr) {
		this.lxr = lxr;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
	public void setGsdz(String gsdz) {
		this.gsdz = gsdz;
	}
	public void setYb(String yb) {
		this.yb = yb;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public void setYhzh(String yhzh) {
		this.yhzh = yhzh;
	}
	public void setSh(String sh) {
		this.sh = sh;
	}
	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}
	public void setBzxx(String bzxx) {
		this.bzxx = bzxx;
	}
	public void setGysbh(int gysbh) {
		this.gysbh = gysbh;
	}
	public void setGysbhs(int[] gysbhs) {
		this.gysbhs = gysbhs;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public Gys getGys() {
		return gys;
	}
	public void setGys(Gys gys) {
		this.gys = gys;
	}


	GysService service = new GysService();
	//--------------------查找所有供应商数据----------------------------
	@ResponseBody
	public String gysShow(){
		List<Gys> gys = service.findGysAll(rows, page);
		int total = service.total();
		PageInfo f = new PageInfo(gys,total);
		String json = JSONObject.fromObject(f).toString();
		return json;
	}
	
	//-------------------保存供应商信息----------------------------------
	public void saveGys(){
		service.saveGys(gys);
	}
	//------------------修改供应商--------------------------------------
	public String findGysByGysbh(){
		gys = service.findGysByGysbh(gysbh);
		return "findGysByGysbh";
	}
	public void updateGys(){
		Gys gys1 = new Gys(gysbh,gysmc,lxr,lxdh,frdb,gsdz,yb,cz,sjhm,yhzh,sh,khyh,bzxx,null,null,null,null,0);
		service.updateGys(gys1);
	}
	//---------------------删除-------------------------------------
	public void deleteGys(){
		service.deleteGys(gysbhs);
	}
}
