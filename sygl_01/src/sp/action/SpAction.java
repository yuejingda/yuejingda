package sp.action;

import java.util.List;

import sp.domain.Sp;
import sp.service.SpService;

public class SpAction {
	private int rows;
	private int page;
	private int total;
	private List<Sp> list;
	private Sp sp;
	private int spbh;
	private String pmgg;
	private String zjm;
	private String xh;
	private String dw;
	private String sb;
	private String cd;
	private int kcsx;
	private int kcxx;
	private int lsj;
	private int pfj1;
	private int pfj2;
	private int pfj3;
	private int[] spbhs;
	
	//---------------接收参数---------------------
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setSpbhs(int[] spbhs) {
		this.spbhs = spbhs;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setSp(Sp sp) {
		this.sp = sp;
	}
	public Sp getSp() {
		return sp;
	}
	
	public void setSpbh(int spbh) {
		this.spbh = spbh;
	}
	public void setPmgg(String pmgg) {
		this.pmgg = pmgg;
	}
	public void setZjm(String zjm) {
		this.zjm = zjm;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public void setSb(String sb) {
		this.sb = sb;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public void setKcsx(int kcsx) {
		this.kcsx = kcsx;
	}
	public void setKcxx(int kcxx) {
		this.kcxx = kcxx;
	}
	public void setLsj(int lsj) {
		this.lsj = lsj;
	}
	public void setPfj1(int pfj1) {
		this.pfj1 = pfj1;
	}
	public void setPfj2(int pfj2) {
		this.pfj2 = pfj2;
	}
	public void setPfj3(int pfj3) {
		this.pfj3 = pfj3;
	}
	//----------------传递参数---------------------
	public int getTotal() {
		return total;
	}
	public List<Sp> getRows() {
		return list;
	}
	//---------------------查找-------------------------
	private SpService service = new SpService();
	public String spShow(){
		this.list = service.findAllByPage(page, rows);
		this.total = service.total();
		return "spShow";
	}
	//--------------------保存--------------------------
	public void saveSp(){
		service.saveSp(sp);
	}
	//-------------------修改-----------------------------
	public String  findSpBySpbh(){
		this.sp = service.findSpBySpbh(spbh);
		return "fingSp";
	}
	public void updateSp(){
		
		Sp sp1 = new Sp(spbh,pmgg,zjm,xh,dw,sb,cd,kcsx,kcxx,lsj,pfj1,pfj2,pfj3,null,null,null,null,0);
		service.updateSp(sp1);
	}
	//------------------删除--------------------------------
	public void deleteSp(){
		service.deleteSp(spbhs);
	}
	
}
