package edu.fudan.mylang.pf.query;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;

public class AnnotationBasedPagedCriteria<T> extends PagedCriteria<T> {
	@Override
	public Collection<T> list() {
		Criteria criteria = buildAnnotationCriteria(this);
		if (!QueryUtil.isNull(getLimit()))
			criteria.setMaxResults(getLimit());
		if (!QueryUtil.isNull(getStart()))
			criteria.setFirstResult(getStart());
		return criteria.list();
	}

	@Override
	public IQueryCriteria<T> includeDeactiveRecords() {
		return this;

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getHQLFrom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHQLBody() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillParameters(Query query) {
		// TODO Auto-generated method stub
		
	}
}
