package edu.fudan.mylang.pf.query;

public interface IPagedCriteria<T> extends IQueryCriteria<T> {

	/**
	 * @return
	 */
	Integer getStart();

	IPagedCriteria<T> setStart(Integer start);

	/**
	 * @return
	 */
	Integer getLimit();

	IPagedCriteria<T> setLimit(Integer limit);

}