package cheryl.sos.service;

import cheryl.sos.domain.PageDisplayInfo;

public interface PageDisplayService {
	abstract public PageDisplayInfo initPageDisplayInfo(String username, String currentPageNum, String limitInOnePage);
}
