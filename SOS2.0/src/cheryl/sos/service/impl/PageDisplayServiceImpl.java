package cheryl.sos.service.impl;

import java.util.List;

import cheryl.sos.domain.Order;
import cheryl.sos.domain.PageDisplayInfo;
import cheryl.sos.service.PageDisplayService;

public class PageDisplayServiceImpl implements PageDisplayService{

	@Override
	public PageDisplayInfo initPageDisplayInfo(String username, String currentPageNum, String limitInOnePage) {
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		List<Order> orders = orderServiceImpl.listOrder(username);
		
		PageDisplayInfo pageDisplayInfo = new PageDisplayInfo(orders);
		
		if(currentPageNum!=null){
			pageDisplayInfo.setCurrentPageNum(Integer.parseInt(currentPageNum));
		}
		if(limitInOnePage!=null){
			pageDisplayInfo.setLimitInOnePage(Integer.parseInt(limitInOnePage));
		}
		
		
		return pageDisplayInfo;
	}
	
	
}
