package kf.domain;

import java.io.Serializable;

public class Kf implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer kfbh;
	private String kfmc;
	private String kfdz;
	public Kf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kf(Integer kfbh, String kfmc, String kfdz) {
		super();
		this.kfbh = kfbh;
		this.kfmc = kfmc;
		this.kfdz = kfdz;
	}
	public Integer getKfbh() {
		return kfbh;
	}
	public void setKfbh(Integer kfbh) {
		this.kfbh = kfbh;
	}
	public String getKfmc() {
		return kfmc;
	}
	public void setKfmc(String kfmc) {
		this.kfmc = kfmc;
	}
	public String getKfdz() {
		return kfdz;
	}
	public void setKfdz(String kfdz) {
		this.kfdz = kfdz;
	}
	
}
