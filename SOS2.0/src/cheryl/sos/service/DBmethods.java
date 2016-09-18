package cheryl.sos.service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public interface DBmethods {
	public boolean insert(String sql,LinkedHashMap<String, String> data);
	public boolean delete(String sql);
	public boolean select(String sql,LinkedHashMap<String, String> data);
}
