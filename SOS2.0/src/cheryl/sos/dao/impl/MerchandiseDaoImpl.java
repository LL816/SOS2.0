package cheryl.sos.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cheryl.sos.dao.MerchandiseDao;
import cheryl.sos.domain.Merchandise;
import cheryl.sos.utils.ConnectDB;

public class MerchandiseDaoImpl implements MerchandiseDao {
	public int merchandiseId=-1;
	@Override
	public List<Merchandise> merchandiseList() {
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<Merchandise> mers = new ArrayList();
	//当查找用户信息属性时，需要修改这里的代码；不再将DBinsert函数单独提取
				
		try{
			conn = ConnectDB.getConnection();
			try {
				String sql = "select * from ordering.merchandise";
				ps = conn.prepareStatement(sql);	
				rs = ps.executeQuery();
				while(rs.next()){
					Merchandise mer = new Merchandise();
					mer.setMerchandiseId(rs.getInt("merchandise_id"));
					mer.setMerchandiseName(rs.getString("merchandise_name"));
					mer.setMerchandisePrice(rs.getFloat("price"));
					mer.setMerchandiseRemaining(rs.getInt("remaining"));
					mers.add(mer);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return mers;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	}

	@Override
	public boolean merchandiseExist(String merchandiseName) {
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
				
		try{
			conn = ConnectDB.getConnection();
			try {
				String sql = "select * from ordering.merchandise where merchandise_name=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1,merchandiseName);
				rs = ps.executeQuery();
				if(rs.next()){
					this.merchandiseId = rs.getInt("merchandise_id");
					return true;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return false;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	}

	@Override
	public int merchandiseRemain(String merchandiseName) {
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
				
		try{
			conn = ConnectDB.getConnection();
			try {
				String sql = "select * from ordering.merchandise where merchandise_name=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1,merchandiseName);
				rs = ps.executeQuery();
				if(rs.next()){
					return rs.getInt("remaining");
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return -1;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	}

	@Override
	public boolean updateRemainNum(int merchandise_id, int before, int after) {
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
				
		try{
			conn = ConnectDB.getConnection();
			try {
				String sql = "update ordering.merchandise set remaining=? where merchandise_id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1,before-after);
				ps.setInt(2, merchandise_id);
				if(ps.executeUpdate()>0)
				{
					return true;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return false;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	}

}
