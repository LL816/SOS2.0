package cheryl.sos.dao;

import java.util.LinkedHashMap;
import java.util.Map;

public interface UserDao {
	abstract public boolean userAdd(String ... var);
	abstract public boolean userDelete(String ... var);
	abstract public boolean userExist(LinkedHashMap<String, String> data);

}
