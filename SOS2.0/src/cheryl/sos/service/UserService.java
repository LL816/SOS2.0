package cheryl.sos.service;

import cheryl.sos.domain.UserInfo;

public interface UserService {
	abstract public boolean register(UserInfo user);
	abstract public boolean login(String username, String passwd);
	abstract public boolean checkValidation(String content, String item);
}
