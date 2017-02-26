package com.tdls.common.page;
/**
 * @method 分页显示的model
 * @author jun.wang7
 *
 */
public class Page {
	public final static int PAGE_SHOW_COUNT = 15;
	private int pageNum = 1;
	private int pageSize =15;
	private int totalCount = 0;
	private int pageCount;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize > 0 ? pageSize : PAGE_SHOW_COUNT;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		int page = this.totalCount % pageSize;
		if (page == 0) {
			pageCount = this.totalCount / pageSize;
		} else {
			pageCount = this.totalCount / pageSize + 1;
		} 
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartIndex() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		return pageNum * this.getPageSize();
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
