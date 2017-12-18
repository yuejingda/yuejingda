package sp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import oracle.jdbc.OracleTypes;
import sp.domain.Sp;
import sp.util.MybatisUtil;

public class SpDao {
		
	
	//===================²éÕÒ=========================
	public List<Sp> findAllByPage(int start,int end){
		String sql = "{CALL PRO_SP_SHOW(?,?,?)}";
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
			List<Sp> sps = new ArrayList<>();
			while(rs.next()){
				int spbh = rs.getInt("spbh");
				String pmgg = rs.getString("pmgg");
				String zjm = rs.getString("zjm");
				String xh = rs.getString("xh");
				String dw = rs.getString("dw");
				String sb = rs.getString("sb");
				String cd = rs.getString("cd");
				int kcsx = rs.getInt("kcsx");
				int kcxx = rs.getInt("kcxx");
				int lsj = rs.getInt("lsj");
				int pfj1 = rs.getInt("pfj1");
				int pfj2 = rs.getInt("pfj2");
				int pfj3 = rs.getInt("pfj3");
				String yl1 = rs.getString("yl1");
				String yl2 = rs.getString("yl2");
				String yl3 = rs.getString("yl3");
				String yl4 = rs.getString("yl4");
				int yl5 = rs.getInt("yl5");
			
				Sp sp = new Sp(spbh, pmgg, zjm, xh, dw, sb, cd, kcsx, kcxx, lsj, pfj1, pfj2, pfj3, yl1, yl2, yl3, yl4, yl5);
				sps.add(sp);
			}
			return sps;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int total(){
		String sql = "{CALL PRO_TOTAL_SP(?)}";
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
	
	//---------------------------Ìí¼Ó-------------------------
	public void saveSp(Sp sp){
		String sql ="{CALL PRO_SAVE_SP(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:bjpowernode",
					"gys",
					"admin");
			CallableStatement stmt = conn.prepareCall(sql);
			stmt.setString(1, sp.getPmgg());
			stmt.setString(2, sp.getZjm());
			stmt.setString(3, sp.getXh());
			stmt.setString(4, sp.getDw());
			stmt.setString(5, sp.getSb());
			stmt.setString(6, sp.getCd());
			stmt.setInt(7, sp.getKcsx());
			stmt.setInt(8, sp.getKcxx());
			stmt.setInt(9, sp.getLsj());
			stmt.setInt(10, sp.getPfj1());
			stmt.setInt(11, sp.getPfj2());
			stmt.setInt(12, sp.getPfj3());
			stmt.setString(13, sp.getYl1());
			stmt.setString(14, sp.getYl2());
			stmt.setString(15, sp.getYl3());
			stmt.setString(16, sp.getYl4());
			stmt.setInt(17, 0);
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//-------------------------------ÐÞ¸Ä----------------------------------
	public Sp fingSpBySpbh(int spbh){
		SqlSession session = MybatisUtil.getSession();
		return session.selectOne("sp.findSpBySpbh", spbh);
	}
	public void updateSp(Sp sp){
		SqlSession session = MybatisUtil.getSession(true);
		session.update("sp.updateSp",sp);
	}
	//--------------------------------É¾³ý----------------------------------
	public void deleteSp(int spbh){
		SqlSession session = MybatisUtil.getSession(true);
		session.delete("sp.deleteSp",spbh);
	}
	
}
