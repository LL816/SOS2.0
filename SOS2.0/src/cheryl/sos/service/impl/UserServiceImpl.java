package cheryl.sos.service.impl;
import java.util.LinkedHashMap;
import java.util.Map;

import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.service.*;

public class UserServiceImpl implements UserService{
	public String messageBuffer="";
	@Override
	public boolean register() {
		
		return false;
	}

	@Override
	public boolean login(String username, String passwd) {

		UserDaoImpl userDaoI=new UserDaoImpl();
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put("user_name", username);
		data.put("passwd", passwd);
		
		if(userDaoI.userExist(data)){
			this.messageBuffer="登陆成功";
			return true;
		}
		else{
			data.remove("passwd");
			if(userDaoI.userExist(data)){
				this.messageBuffer="用户存在，密码错误";
				return false;
			}
			else{
				this.messageBuffer="该用户不存在";
				return false;
			}
			
		}

	}
	
}
