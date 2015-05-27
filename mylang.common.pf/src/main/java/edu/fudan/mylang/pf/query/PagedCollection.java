package edu.fudan.mylang.pf.query;

import java.util.Arrays;
import java.util.Collection;

import org.hibernate.Query;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class PagedCollection<T> extends PagedCriteria<T> implements
		IPagedCriteria<T> {

	Collection<T> elements;

	public PagedCollection(Collection<T> elements) {
		this.elements = elements;
	}

	@Override
	public Collection<T> list() {
		Iterable<T> iterable = Iterables.limit(
				Iterables.skip(elements, this.getStart()), this.getLimit());
		return Lists.newArrayList(iterable);
	}

	@Override
	public Integer count() {
		return elements.size();
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
