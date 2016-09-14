package cheryl.sos.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectDB {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Properties prop = new Properties();
	static FileInputStream inStream = null;
	
	static{//只需要加载一次
		try {
			prop.load(ConnectDB.class.getClassLoader().getResourceAsStream("db.properties"));
// A resource is some data (images, audio, text, etc) that can be accessed by class code in a way that is independent of the location of the code.
//			inStream = new FileInputStream("db.properties"); 如果项目发布，或是移动位置，可能导致找不到文件

		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);//不是异常，是错误
		}
		
		try {
			String driver = prop.getProperty("jdbc.driver");

			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}				
		
	}
	
	public static Connection getConnection(){//创建连接
		try {
			String url = prop.getProperty("jdbc.url");
			String user = prop.getProperty("jdbc.user");
			String passwd = prop.getProperty("jdbc.passwd");

			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}
	public static void release(Connection conn, PreparedStatement ps, ResultSet rs){//销毁连接
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			rs=null;
		}
		if(ps!=null){
			try{
				ps.close();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			ps=null;
		}		
		if(rs!=null){
			try{
				rs.close();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
			rs=null;
		}
	}
			
}
