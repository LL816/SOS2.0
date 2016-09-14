package cheryl.test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.service.impl.DBmethodsImp;
import cheryl.sos.utils.ConnectDB;

public class JunitTest {
	@Test
	public void testConnectDB(){
		ConnectDB db = new ConnectDB();
	}
	@Test
	public void testTemp(){
		
	}
	@Test
	public void testUserExist(){
		UserDaoImpl dao = new UserDaoImpl();
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put("user_name", "cheryl");
		data.put("passwd", "cheryl");
		dao.userExist(data);
	}
	@Test
	public void testSelect(){
		DBmethodsImp dbimp=new DBmethodsImp();
		String sql = "select * from ordering.usersinfo where user_name=? and passwd=?";
		
	}
}
