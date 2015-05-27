package edu.fudan.mylang.pf.query;


public abstract class PagedCriteria<T> extends BaseQueryCriteria<T> implements
		IPagedCriteria<T> {

	Integer limit;
	Integer start;

	public Integer getLimit() {
		return limit;
	}

	public IPagedCriteria<T> setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	public Integer getStart() {
		return start;
	}

	public IPagedCriteria<T> setStart(Integer start) {
		this.start = start;
		return this;
	}

}
