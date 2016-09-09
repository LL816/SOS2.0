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
	
	static{
		try {
			inStream = new FileInputStream("src/db.properties");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			prop.load(inStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		try {
			String driver = prop.getProperty("jdbc.driver");
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}				
		try {
			String url = prop.getProperty("jdbc.url");
			String user = prop.getProperty("jdbc.user");
			String passwd = prop.getProperty("jdbc.password");
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static boolean insert(String sql){
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}
	
	public static boolean delete(String sql){
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}
	public static boolean select(String sql){
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return false;
	}
			
}
