package cheryl.sos.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import cheryl.sos.dao.UserDao;
import cheryl.sos.domain.UserInfo;
import cheryl.sos.utils.*;

public class UserDaoImpl implements UserDao  {
	public boolean userAdd(UserInfo user){

		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
//当修改用户信息属性时，需要修改这里的代码；不再将DBinsert函数单独提取
		String sql = "insert into ordering.usersinfo (user_name,passwd) values (?, ?)";
		try{
			conn = ConnectDB.getConnection();
			try {
				 ps = conn.prepareStatement(sql);
				 ps.setString(1,user.getUserName());
				 ps.setString(2,user.getPassWd());
				 if(ps.executeUpdate()!=0){
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
	public boolean userDelete(String ... var){
		boolean status=false;
		
		return status;
	}
	public boolean userExist(String... items){
		
		Connection conn = null; 
		PreparedStatement ps = null;
		ResultSet rs =null;
	//当查找用户信息属性时，需要修改这里的代码；不再将DBinsert函数单独提取
				
		try{
			conn = ConnectDB.getConnection();
			try {
				if(items.length==2){
					String sql = "select * from ordering.usersinfo where user_name=? and passwd=?";
					ps = conn.prepareStatement(sql);
					ps.setString(1,items[0]);
					ps.setString(2,items[1]);
				}
				else if(items.length==1){
					String sql = "select * from ordering.usersinfo where user_name=?";
					ps = conn.prepareStatement(sql);
					ps.setString(1,items[0]);
				}
				else{
					throw new RuntimeException("undefined argument");
				}	
				rs = ps.executeQuery();
				if(rs.next()){
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
