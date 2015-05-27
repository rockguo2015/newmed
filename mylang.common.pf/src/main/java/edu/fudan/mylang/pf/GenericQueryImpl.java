package edu.fudan.mylang.pf;

import java.util.Collection;

import org.hibernate.Query;

public class GenericQueryImpl<T> implements IParameterizedQuery<T > {

	private Query query;
	
	public GenericQueryImpl(IObjectFactory objectFactory, String hql){
		query = objectFactory.createQuery(hql);
	}
	@Override
	public Collection<T> list() {
		return query.list();
	}

	@Override
	public T uniqueResult() {
		return (T) query.uniqueResult();
	}
	@Override
	public IParameterizedQuery<T> setParameter(String paramName, Object value) {
		query.setParameter(paramName, value);
		return this;
	}
	@Override
	public IParameterizedQuery<T> setParameterList(String name,
			Collection<?> vals) {
		query.setParameterList(name, vals);
		return this;
	}
	@Override
	public IGenericQuery<T> setMaxResults(int maxResults) {
		query.setMaxResults(maxResults);
		return this;
	}

}
