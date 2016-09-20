package cheryl.sos.service.impl;

import java.util.List;

import cheryl.sos.dao.impl.MerchandiseDaoImpl;
import cheryl.sos.domain.Merchandise;
import cheryl.sos.domain.Order;
import cheryl.sos.service.MerchandiseService;

public class MerchandiseServiceImpl implements MerchandiseService{

	@Override
	public List<Merchandise> listMerchandise() {
		MerchandiseDaoImpl merDaoImpl = new MerchandiseDaoImpl();
		return merDaoImpl.merchandiseList();
		
	}

	@Override
	public boolean updateRemainNum(Order order) {
		MerchandiseDaoImpl merchandiseDaoImpl = new MerchandiseDaoImpl();
		int merchandise_id=-1;
		if(merchandiseDaoImpl.merchandiseExist(order.getMerchandiseName())){
			merchandise_id = merchandiseDaoImpl.merchandiseId;
		}
		else{
			throw new RuntimeException("fail to find merchandise id");
		}
		int num = order.getNum();
		int original = merchandiseDaoImpl.merchandiseRemain(order.getMerchandiseName());
		if(merchandiseDaoImpl.updateRemainNum(merchandise_id, original ,num)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
