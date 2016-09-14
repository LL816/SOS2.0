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
	
	static{//ֻ��Ҫ����һ��
		try {
			prop.load(ConnectDB.class.getClassLoader().getResourceAsStream("db.properties"));
// A resource is some data (images, audio, text, etc) that can be accessed by class code in a way that is independent of the location of the code.
//			inStream = new FileInputStream("db.properties"); �����Ŀ�����������ƶ�λ�ã����ܵ����Ҳ����ļ�

		} catch (IOException e) {
			throw new ExceptionInInitializerError(e);//�����쳣���Ǵ���
		}
		
		try {
			String driver = prop.getProperty("jdbc.driver");

			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}				
		
	}
	
	public static Connection getConnection(){//��������
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
	public static void release(Connection conn, PreparedStatement ps, ResultSet rs){//��������
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
