package cheryl.sos.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import cheryl.sos.domain.UserInfo;

public interface UserDao {
	abstract public boolean userAdd(UserInfo user);
	abstract public boolean userDelete(String ... var);
	abstract public boolean userExist(String... item );

}
