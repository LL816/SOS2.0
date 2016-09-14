package cheryl.sos.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import cheryl.sos.utils.ConnectDB;

public class DBmethodsImp {
	public boolean insert(String sql){
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = ConnectDB.getConnection();
			try {
				 ps = conn.prepareStatement(sql);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return false;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}

	}
	
	public boolean delete(String sql){
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = ConnectDB.getConnection();
			try {
				 ps = conn.prepareStatement(sql);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return false;
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	}
	public boolean select(String sql,LinkedHashMap<String, String> data){
				
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = ConnectDB.getConnection();
			try {
				 ps = conn.prepareStatement(sql);
				 Set<Entry<String,String>> entryset = data.entrySet();
				 int index=1;
				 
				 for(Entry<String, String> en:entryset){
					 ps.setString(index, en.getValue());
					 index++;
				 }
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			try {
				rs = ps.executeQuery();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			try {
				if(rs.next()){
					return true;
				}
				else{
					return false;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}finally{//确保释放，否则系统很可能崩溃
			ConnectDB.release(conn, ps, rs);
		}
	
		
		

	}
}
