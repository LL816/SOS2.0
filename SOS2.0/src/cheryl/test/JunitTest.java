package cheryl.test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.utils.ConnectDB;

public class JunitTest {
	@Test
	public void testConnectDB(){
		ConnectDB db = new ConnectDB();
	}

}
