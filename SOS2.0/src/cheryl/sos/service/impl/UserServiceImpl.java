package cheryl.sos.service.impl;
import java.util.LinkedHashMap;
import java.util.Map;

import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.domain.UserInfo;
import cheryl.sos.service.*;

public class UserServiceImpl implements UserService{
	public String messageBuffer="";
	@Override
	public boolean register(UserInfo user) {
		UserDaoImpl userDaoI=new UserDaoImpl();
		/*javaBean����map����
		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put("user_name", username);
		data.put("passwd", passwd);
		*/
		if(userDaoI.userAdd(user)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean login(String username, String passwd) {

		UserDaoImpl userDaoI=new UserDaoImpl();
/*		LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
		data.put("user_name", username);
		data.put("passwd", passwd);
*/		
		if (!checkValidation(username,"username")){
			this.messageBuffer="�û������Ϸ�";
			return false;
		}
		else if (!checkValidation(passwd,"passwd")){
			this.messageBuffer="���벻�Ϸ�";
			return false;
		}
		else if(userDaoI.userExist(username, passwd)){
			this.messageBuffer="��½�ɹ�";
			return true;
		}
		else{
			if(userDaoI.userExist(username)){
				this.messageBuffer="�û����ڣ��������";
				return false;
			}
			else{
				this.messageBuffer="���û�������";
				return false;
			}
			
		}

	}

	@Override
	public boolean checkValidation(String content, String item) {//�û�����������Ҫ��ͬ�������淶ʱ����item�ж���Ҫ��֤������һ�׹淶
		int contentLength = content.length();
		if(contentLength>18 || contentLength<6){
			return false;
		}
		return true;
	}
	
}
