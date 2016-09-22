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
		

		if(limitInOnePage!=null && Integer.parseInt(limitInOnePage)!=pageDisplayInfo.getLimitInOnePage()){
			pageDisplayInfo.setLimitInOnePage(Integer.parseInt(limitInOnePage));
		}
		if(currentPageNum!=null&& Integer.parseInt(currentPageNum)!=pageDisplayInfo.getCurrentPageNum()){
			pageDisplayInfo.setCurrentPageNum(Integer.parseInt(currentPageNum));
		}
		
		return pageDisplayInfo;
	}
	
	
}
