package cheryl.sos.domain;

import java.util.ArrayList;
import java.util.List;

public class PageDisplayInfo {
	private List<?> data;
	private List<?> dataToBeDisplayed;
	private int startIndex;
	private int totalIndex;
	private int limitInOnePage;
	private int currentPageNum;
	private int previousPageNum;
	private int nextPageNum;
	private int totalPageNum;
	private List<Integer> pageBar=new ArrayList();
	
	public PageDisplayInfo(List<?> data){
		this.data = data;
		this.limitInOnePage=10;
		this.totalIndex = data.size();
		this.currentPageNum = 1;


		this.startIndex=(this.currentPageNum-1)*this.limitInOnePage;
		this.previousPageNum = this.currentPageNum>1?(this.currentPageNum-1):1;
		this.totalPageNum = this.totalIndex % this.limitInOnePage == 0 ? (this.totalIndex / this.limitInOnePage) : (this.totalIndex / this.limitInOnePage +1);
		this.nextPageNum = this.currentPageNum<this.totalPageNum?(this.currentPageNum+1):this.totalPageNum;
		this.dataToBeDisplayed = data.subList(startIndex, (startIndex+limitInOnePage)<totalIndex?(startIndex+limitInOnePage):totalIndex);
		for(int i=1;i<=this.totalPageNum;i++){
			pageBar.add(i);
		}
	}

	
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public List<?> getDataToBeDisplayed() {
		return dataToBeDisplayed;
	}
	public void setDataToBeDisplayed(List<?> dataToBeDisplayed) {
		this.dataToBeDisplayed = dataToBeDisplayed;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getTotalIndex() {
		return totalIndex;
	}
	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}
	public int getLimitInOnePage() {
		return limitInOnePage;
	}
	public void setLimitInOnePage(int limitInOnePage) {
		this.limitInOnePage = limitInOnePage;
		this.startIndex=(this.currentPageNum-1)*this.limitInOnePage;
		this.totalPageNum = this.totalIndex % this.limitInOnePage == 0 ? (this.totalIndex / this.limitInOnePage) : (this.totalIndex / this.limitInOnePage +1);
		pageBar.clear();
		for(int i=1;i<=this.totalPageNum;i++){
			pageBar.add(i);
		}
		this.dataToBeDisplayed = data.subList(startIndex, (startIndex+limitInOnePage)<totalIndex?(startIndex+limitInOnePage):totalIndex);

	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currenPageNum) {
		this.currentPageNum = currenPageNum;
		this.startIndex=(this.currentPageNum-1)*this.limitInOnePage;
		this.previousPageNum = this.currentPageNum>1?(this.currentPageNum-1):1;
		this.nextPageNum = this.currentPageNum<this.totalPageNum?(this.currentPageNum+1):this.totalPageNum;
		this.dataToBeDisplayed = data.subList(startIndex, (startIndex+limitInOnePage)<totalIndex?(startIndex+limitInOnePage):totalIndex);
	}
	public int getPreviousPageNum() {
		return previousPageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}
	
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public List<Integer> getPageBar() {
		return pageBar;
	}


	
}
