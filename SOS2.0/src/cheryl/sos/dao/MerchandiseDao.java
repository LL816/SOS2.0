package cheryl.sos.dao;

import java.util.List;

import cheryl.sos.domain.Merchandise;
import cheryl.sos.domain.Order;

public interface MerchandiseDao {
	public abstract List<Merchandise> merchandiseList();
	public abstract boolean merchandiseExist(String merchandiseName);
	public abstract int merchandiseRemain(String merchandiseName);
	abstract public boolean updateRemainNum(int merchandise_id, int before, int after);
}
