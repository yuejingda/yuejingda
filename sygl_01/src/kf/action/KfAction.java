package kf.action;

import java.util.List;

import kf.domain.Kf;
import kf.service.KfService;

public class KfAction {
	private int rows;
	private int page;
	private List<Kf> list;
	private int total;
	private Kf kf;
	private int kfbh;
	private String kfmc;
	private String kfdz;
	private int[] kfbhs;
	//---------------------接收参数------------------------
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setKfbhs(int[] kfbhs) {
		this.kfbhs = kfbhs;
	}
	public void setKfmc(String kfmc) {
		this.kfmc = kfmc;
	}
	public void setKfdz(String kfdz) {
		this.kfdz = kfdz;
	}
	public void setKfbh(int kfbh) {
		this.kfbh = kfbh;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public Kf getKf() {
		return kf;
	}
	public void setKf(Kf kf) {
		this.kf = kf;
	}
	//-----------------------传递参数--------------------------
	public List<Kf> getRows() {
		return list;
	}
	public int getTotal() {
		return total;
	}

	//------------------------功能代码-------------------------
	private KfService service = new KfService();
	
	//----------------------查找所有库房信息----------------------
	public String kfShow(){
		
		this.list = service.findKfByPage(rows, page);
		this.total = service.total();
		return "findAll";
	}
	//--------------------添加---------------------------------
	public void saveKf(){
		service.saveKf(kf);
	}
	//------------------修改库房信息------------------------------
	public String findKfByKfbh(){
		this.kf = service.fingKfByKfbh(kfbh);
		return "findKfByKfbh";
	}
	public void updateKf(){
		Kf kf1 = new Kf(kfbh,kfmc,kfdz);
		service.updateKf(kf1);
	}
	//-----------------删除----------------------------------------
	public void deleteKf(){
		service.deleteKf(kfbhs);
	}
}
