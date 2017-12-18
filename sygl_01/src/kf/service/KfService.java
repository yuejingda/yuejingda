package kf.service;

import java.util.List;

import kf.dao.KfDao;
import kf.domain.Kf;

public class KfService {
	private KfDao dao = new KfDao();
	
	//---------------------��ҳ����---------------------
	public List<Kf> findKfByPage(int rows,int page){
		int start = (page-1)*rows +1;
		int end = start +rows -1;
		return dao.findKfByPage(start, end);
	}
	public int total(){
		return dao.total();
	}
	//--------------------���-----------------------------
	public void saveKf(Kf kf){
		dao.saveKf(kf);
	}
	//--------------------�޸Ŀⷿ��Ϣ------------------------
	public Kf fingKfByKfbh(int kfbh){
		return dao.findKfByKfbh(kfbh);
	}
	public void updateKf(Kf kf){
		dao.updateKf(kf);
	}
	//-------------------ɾ��--------------------------------
	public void deleteKf(int[] kfbhs){
		for(int kfbh:kfbhs){
			dao.deleteKf(kfbh);
		}
	}
}















