package edu.fudan.mylang.pf.query;

import java.util.Collection;

import org.hibernate.Query;

public abstract class HQLBasedPagedQueryCriteria<T> extends PagedCriteria<T> {

	protected abstract String buildHQLFrom();

	protected abstract String buildHQLBody();

	protected abstract void fillParameter(Query query);

	public void initOrderBys() {
	}

	protected Boolean isDistinct() {
		return false;
	}

	@Override
	public Collection<T> list() {
		postInitialize();
		String hql = "select " + (isDistinct() ? "distinct" : "") + " this "
				+ buildHQLFrom() + internalBuildHQLBody()
				+ buildOrderByString();
		Query query = this.createQuery(hql);
		if (this.getStart() != null)
			query.setFirstResult(this.getStart());
		if (this.getLimit() != null)
			query.setMaxResults(this.getLimit());
		fillParameter(query);
		return query.list();

	}

	@Override
	public Integer count() {
		postInitialize();
		String sql = "select count( " + (isDistinct() ? "distinct" : "")
				+ " this) " + buildHQLFrom() + internalBuildHQLBody();
		Query query = this.createQuery(sql);
		fillParameter(query);
		Long count = (Long) query.uniqueResult();
		if (count == null)
			return 0;
		return ((Long) query.uniqueResult()).intValue();

	}

	protected String buildOrderByString() {
		String orderString = "";
		boolean isFirst = true;
		for (OrderItem orderItem : getOrderItems()) {
			if (!isFirst)
				orderString += ",";
			else
				isFirst = false;
			orderString += orderItem.toString();

		}
		if (orderString.length() != 0)
			return " order by " + orderString;
		else
			return "";
	}

	@Override
	public T uniqueResult() {
		postInitialize();

		String hql = "select " + (isDistinct() ? "distinct" : "") + " this "
				+ buildHQLFrom() + internalBuildHQLBody()
				+ buildOrderByString();
		Query query = this.createQuery(hql);
		fillParameter(query);
		return (T) query.uniqueResult();
	}

	@Override
	public void deleteAll() {
		postInitialize();
		String hql = "delete " + buildHQLFrom() + internalBuildHQLBody();
		Query query = this.createQuery(hql);
		fillParameter(query);
		query.executeUpdate();
	}

	boolean includeDeactiveRecords = false;

	public IQueryCriteria<T> includeDeactiveRecords() {
		this.includeDeactiveRecords = true;
		return this;
	}

	private String internalBuildHQLBody() {
		if (!includeDeactiveRecords)
			return buildHQLBody() + " and this.active=1";
		else
			return buildHQLBody();
	}

	public String getHQLFrom() {
		return buildHQLFrom();
	}

	public String getHQLBody() {
		return buildHQLBody();
	}

	public void fillParameters(Query query) {
		fillParameter(query);
	}

	public <ST, SC extends IStatCriteria<ST>> SC createStatCriteria(Class<SC> c) {
		SC result = super.createStatCriteria(c);
		if(getStart()!=null)
			result.setFirstResult(getStart());
		if(getLimit()!=null)
			result.setMaxResult(getLimit());
		return result;
	}

}
