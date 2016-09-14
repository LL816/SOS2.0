package cheryl.sos.service;

import java.sql.SQLException;
import java.util.Map;

public interface DBmethods {
	public boolean insert(String sql);
	public boolean delete(String sql);
	public boolean select(String sql,String... var);
}
