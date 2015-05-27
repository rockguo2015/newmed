package edu.fudan.mylang.pf.query;

import java.util.ArrayList;
import java.util.Collection;

import edu.fudan.mylang.pf.IObjectFactory;

public abstract class BaseStatCriteria<T> implements IStatCriteria<T> {
	
	private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public IStatCriteria<T> addOrder(String field, int order) {
		orderItems.add(new OrderItem(field, order));
		return this;
	}
	protected String buildOrderByString() {
		String orderString = "";
		boolean isFirst = true;
		for (OrderItem orderItem : orderItems) {
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
	
	public void initOrderBys() {
	}

	protected IQueryCriteria<?> criteria;

	protected IObjectFactory entities;

	@Override
	public void setCriteria(IQueryCriteria<?> criteria) {
		this.criteria = criteria;
	}

	public void setObjectFactory(IObjectFactory objectFactory) {
		this.entities = objectFactory;
	}
  Integer maxResult = null;
  Integer firstResult = null;
  protected Collection<T> doList(org.hibernate.Query query){
	  if(maxResult!=null)
		  query.setMaxResults(maxResult);
	  if(firstResult!=null)
		  query.setFirstResult(firstResult);
	  return (Collection<T>) query.list();
  }
  
  public IStatCriteria<T> setMaxResult(Integer maxResult){
	  this.maxResult = maxResult;
	  return this;
  }
  
  public IStatCriteria<T> setFirstResult(Integer firstResult){
	  this.firstResult = firstResult;
	  return this;
  }
  @Override
  public Integer getFirstResult() {
  	return firstResult;
  }

  @Override
  public Integer getMaxResult() {
  	return maxResult;
  }
  
  public Integer count(){
	  return 100;
  }
  
}
