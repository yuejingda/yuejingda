package sp.service;

import java.util.List;

import sp.dao.SpDao;
import sp.domain.Sp;

public class SpService {
	
	
	private SpDao dao = new SpDao();
	//---------����----------------------
	public List<Sp> findAllByPage(int page,int rows){
		int start = (page-1)*rows +1;
		int end = start +rows -1;
		return dao.findAllByPage(start, end);
	}
	public int total(){
		return dao.total();
	}
	//------------------���-------------------
	public void saveSp(Sp sp){
		dao.saveSp(sp);
	}
	//------------------�޸�--------------------
	public Sp findSpBySpbh(int spbh){
		return dao.fingSpBySpbh(spbh);
	}
	public void updateSp(Sp sp){
		dao.updateSp(sp);
	}
	//-----------------ɾ��------------------------
	public void deleteSp(int[] spbhs){
		for(int spbh : spbhs){
			dao.deleteSp(spbh);
		}
	}
}










