package cheryl.sos.service;

public interface UserService {
	abstract public boolean register();
	abstract public boolean login(String username, String passwd);
}
