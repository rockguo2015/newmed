package edu.fudan.mylang.pf;

import java.util.Collection;
import java.util.Map;

import org.hibernate.Query;

public class MapQueryImpl implements IParameterizedQuery<Map<String, Object>> {

	private Query query;

	public MapQueryImpl(IObjectFactory objectFactory, String hql) {
		query = objectFactory.createQuery(hql);
	}

	@Override
	public Collection<Map<String, Object>> list() {
		return query.list();
	}

	@Override
	public Map<String, Object> uniqueResult() {
		return (Map<String, Object>) query.uniqueResult();
	}

	@Override
	public IGenericQuery<Map<String, Object>> setMaxResults(int maxResults) {
		query.setMaxResults(maxResults);
		return this;
	}

	@Override
	public IParameterizedQuery<Map<String, Object>> setParameter(
			String paramName, Object value) {
		query.setParameter(paramName, value);
		return this;
	}

	@Override
	public IParameterizedQuery<Map<String, Object>> setParameterList(
			String name, Collection<?> vals) {
		query.setParameterList(name, vals);
		return this;
	}

}
