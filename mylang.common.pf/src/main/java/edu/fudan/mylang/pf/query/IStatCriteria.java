package edu.fudan.mylang.pf.query;

import java.util.Collection;

import edu.fudan.mylang.pf.IObjectFactory;

public interface IStatCriteria<T> {

	public void setCriteria(IQueryCriteria<?> queryCriteria);

	public void setObjectFactory(IObjectFactory objectFactory);

	public IStatCriteria<T> setMaxResult(Integer maxResult);

	public IStatCriteria<T> setFirstResult(Integer maxResult);

	Integer getMaxResult();

	Integer getFirstResult();

	public Collection<T> list();
	
	public Integer count();

}
