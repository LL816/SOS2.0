package cheryl.sos.dao.impl;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import cheryl.sos.dao.UserDao;
import cheryl.sos.service.impl.DBmethodsImp;
import cheryl.sos.utils.*;

public class UserDaoImpl implements UserDao  {
	public boolean userAdd(String ... var){
		boolean status=false;
		String sql=null;
		DBmethodsImp dbI=new DBmethodsImp();
		
		sql = "insert into ordering.usersinfo (?) values (?) ";
		
		return status;
	}
	public boolean userDelete(String ... var){
		boolean status=false;
		
		return status;
	}
	public boolean userExist(LinkedHashMap<String, String> data){
		boolean status=false;
		StringBuffer sql = new StringBuffer();
		DBmethodsImp dbI=new DBmethodsImp();
		sql.append("select * from ordering.usersinfo where ");
		Set<String> keys = data.keySet();
		for(String key:keys){
			sql.append(key);
			sql.append("=? and ");
		}
		sql.replace(sql.lastIndexOf("and"),sql.lastIndexOf("and")+3,"  ");
		String sqlProcessed = sql.toString().trim();
		if(dbI.select(sqlProcessed, data)){
			status=true;
		}
		return status;
	}

}
