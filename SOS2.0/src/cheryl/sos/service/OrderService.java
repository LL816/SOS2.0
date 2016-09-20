package cheryl.sos.service;

import java.util.List;

import cheryl.sos.domain.Order;

public interface OrderService {
	abstract public boolean addOrder(Order order,String username);
	abstract public List<Order> listOrder(String username);
	abstract public boolean removeOrder(String order_id);

}
