package cheryl.sos.dao;

import java.util.List;

import cheryl.sos.domain.Order;

public interface OrderDao {
	abstract public boolean addOrder(int user_id, int merchandise_id, int num);
	abstract public List<Order> listOrder(String username);
	abstract public boolean removeOrder(String order_id);
	abstract public List<Integer> singleOrder(String order_id);

}
