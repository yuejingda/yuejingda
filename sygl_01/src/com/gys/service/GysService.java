package com.gys.service;

import java.util.List;

import com.gys.dao.GysDao;
import com.gys.domain.Gys;

public class GysService {
		
		GysDao dao = new GysDao();
	//-----------------�������й�Ӧ��--------------------
		public List<Gys> findGysAll(int rows,int page){
			int start = (page-1)*rows + 1;
			int end = start + rows -1;
			return dao.findGysAll(start, end);
		}
		public int total(){
			return dao.total();
		}
		//-----------��ӹ�Ӧ��-----------------------
		public void saveGys(Gys gys){
			dao.saveGys(gys);
		}
		//---------------�޸Ĺ�Ӧ����Ϣ-----------------
		public Gys findGysByGysbh(int gysbh){
			return dao.findGysByGysbh(gysbh);
		}
		public void updateGys(Gys gys){
			dao.updateGys(gys);
		}
		//------------------ɾ��--------------------
		public void deleteGys(int[] gysbhs){
			for(int gysbh:gysbhs){
				dao.deleteGys(gysbh);
			}
		}
}
