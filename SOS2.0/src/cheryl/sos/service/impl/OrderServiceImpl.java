package cheryl.sos.service.impl;

import java.util.List;

import cheryl.sos.dao.impl.MerchandiseDaoImpl;
import cheryl.sos.dao.impl.OrderDaoImpl;
import cheryl.sos.dao.impl.UserDaoImpl;
import cheryl.sos.domain.Order;
import cheryl.sos.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public boolean addOrder(Order order, String username) {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		MerchandiseServiceImpl merchandiseServiceImpl = new MerchandiseServiceImpl();
		MerchandiseDaoImpl merchandiseDaoImpl = new MerchandiseDaoImpl();
		int user_id =-1;
		int merchandise_id=-1;
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		if(userDaoImpl.userExist(username)){
			user_id = userDaoImpl.userId;
		}
		else{
			throw new RuntimeException("fail to find user id");
		}
		
		if(merchandiseDaoImpl.merchandiseExist(order.getMerchandiseName())){
			merchandise_id = merchandiseDaoImpl.merchandiseId;
		}
		else{
			throw new RuntimeException("fail to find merchandise id");
		}
		
		return (orderDaoImpl.addOrder(user_id, merchandise_id, order.getNum()) && merchandiseServiceImpl.updateRemainNum(order));
	}

	@Override
	public List<Order> listOrder(String username) {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		return orderDaoImpl.listOrder(username);
	}

	@Override
	public boolean removeOrder(String string) {
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		MerchandiseDaoImpl merchandiseDaoImpl = new MerchandiseDaoImpl();
		List<Integer> list = orderDaoImpl.singleOrder(string);
		return (orderDaoImpl.removeOrder(string) && merchandiseDaoImpl.updateRemainNum(list.get(0), list.get(1) , -list.get(2)));
	}

}
