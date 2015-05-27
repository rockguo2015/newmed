package com.uniquesoft.gwt.shared.common.pager;

/**
 * To get the information of a established page in a ListGrid, Set or get the page information.
 *
 */
public interface IPagedCriteria {
	
	/**
	 * @return A number about the current page, start from 1
	 */
	Integer getPage();
	
	/**
	 * @param page the established number of pages to show
	 */
	void setPage(Integer page);
	/**
	 * @return The total page number
	 */
	Integer getPageSize();

	/**
	 * @param start the total page number that will be used to show all records
	 */
	void setPageSize(Integer start);

}
