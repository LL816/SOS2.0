package cheryl.sos.service;

public interface UserService {
	abstract public boolean register(String username, String passwd);
	abstract public boolean login(String username, String passwd);
	abstract public boolean checkValidation(String content, String item);
}
