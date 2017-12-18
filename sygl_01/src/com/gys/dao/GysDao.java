package com.gys.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gys.domain.Gys;

import oracle.jdbc.OracleTypes;
import sp.util.MybatisUtil;

public class GysDao {
	public List<Gys> findGysAll(int start,int end){
		String sql = "{CALL PRO_GYS_SHOW(?,?,?)}";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:bjpowernode",
					"gys",
					"admin");
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			stmt.registerOutParameter(3, OracleTypes.CURSOR);
			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(3);
			List<Gys> gyses = new ArrayList<>();
			while(rs.next()){
				int gysbh = rs.getInt("gysbh");
				String gysmc = rs.getString("gysmc");
				String lxr = rs.getString("lxr");
				String lxdh = rs.getString("lxdh");
				String frdb = rs.getString("frdb");
				String gsdz = rs.getString("gsdz");
				String yb = rs.getString("yb");
				String cz = rs.getString("cz");
				String sjhm = rs.getString("sjhm");
				String yhzh = rs.getString("yhzh");
				String sh = rs.getString("sh");
				String khyh = rs.getString("khyh");
				String bzxx = rs.getString("bzxx");
				String yl1 = rs.getString("yl1");
				String yl2 = rs.getString("yl2");
				String yl3 = rs.getString("yl3");
				String yl4 = rs.getString("yl4");
				int yl5 = rs.getInt("yl5");
				Gys gys = new Gys(gysbh,gysmc,lxr,lxdh,frdb,gsdz,yb,cz,sjhm,yhzh,sh,khyh,bzxx,yl1,yl2,yl3,yl4,yl5);
				gyses.add(gys);
			}
			return gyses;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public int total(){
		String sql = "{CALL PRO_TOTAL(?)}";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:bjpowernode",
					"gys",
					"admin");
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.INTEGER);
			stmt.execute();
			return stmt.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//------------------保存供应商------------------------------
	public void saveGys(Gys gys){
		String sql="{CALL PRO_SAVE_GYS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:bjpowernode",
					"gys",
					"admin");
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1,gys.getGysmc());
			stmt.setString(2,gys.getLxr());
			stmt.setString(3,gys.getLxdh());
			stmt.setString(4,gys.getFrdb());
			stmt.setString(5,gys.getGsdz());
			stmt.setString(6,gys.getYb());
			stmt.setString(7,gys.getCz());
			stmt.setString(8,gys.getSjhm());
			stmt.setString(9,gys.getYhzh());
			stmt.setString(10,gys.getSh());
			stmt.setString(11,gys.getKhyh());
			stmt.setString(12,gys.getBzxx());
			stmt.setString(13,gys.getYl1());
			stmt.setString(14,gys.getYl2());
			stmt.setString(15,gys.getYl3());
			stmt.setString(16,gys.getYl4());
			stmt.setInt(17,0);
			stmt.execute();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//--------------------修改------------------------
	public Gys findGysByGysbh(int gysbh){
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("gys.findGysByGysbh", gysbh);
	}
	public void updateGys(Gys gys){
		SqlSession session = MybatisUtil.getSession(true);
		session.update("gys.updateGys",gys);
	}
	//---------------------删除-----------------------
	public void deleteGys(int gysbh){
		SqlSession session = MybatisUtil.getSession(true);
		session.delete("gys.deleteGys",gysbh);
	}
}
