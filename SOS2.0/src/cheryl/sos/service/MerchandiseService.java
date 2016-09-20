package cheryl.sos.service;

import java.util.List;

import cheryl.sos.domain.Merchandise;
import cheryl.sos.domain.Order;

public interface MerchandiseService {
	abstract public List<Merchandise> listMerchandise();
	abstract public boolean updateRemainNum(Order order);
}
