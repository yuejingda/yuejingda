package kf.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import kf.domain.Kf;
import sp.util.MybatisUtil;

public class KfDao {
	//-----------------����----------------------
	
	public List<Kf> findKfByPage(int start,int end){
		SqlSession session = MybatisUtil.getSession();
		Map<String,Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return session.selectList("kf.findAll", map);
	}
	public int total(){
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("kf.findCount");
	}
	
	//---------------------����-----------------------
	public void saveKf(Kf kf){
		SqlSession session = MybatisUtil.getSession(true);
		session.insert("kf.saveKf",kf);
	}
	//--------------------�޸���Ϣ-----------------------
	public Kf findKfByKfbh(int kfbh){
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("kf.findKfByKfbh", kfbh);
	}
	public void updateKf(Kf kf){
		SqlSession session = MybatisUtil.getSession(true);
		session.update("kf.updateKf",kf);
	}
	//--------------------ɾ��--------------------------
	public void deleteKf(int kfbh){
		SqlSession session = MybatisUtil.getSession(true);
		session.delete("kf.deleteKf",kfbh);
	}

}
