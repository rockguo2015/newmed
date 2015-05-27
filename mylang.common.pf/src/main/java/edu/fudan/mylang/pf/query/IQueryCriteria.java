package edu.fudan.mylang.pf.query;

import java.util.Collection;

import org.hibernate.Query;
import org.springframework.beans.factory.BeanFactory;

public interface IQueryCriteria<T> {
	
	void initialize(BeanFactory context);
	
	void postInitialize();

	OrderItem getOrderItem();

	IQueryCriteria<T> setOrder(String field, int order);
	
	IQueryCriteria<T> addOrder(String field, int order);
	
	IQueryCriteria<T> addASC(String field);
	
	IQueryCriteria<T> addDESC(String field);
	
	Collection<T> list();
	
	T uniqueResult();

	Integer count();
	
	void deleteAll();
	
	IQueryCriteria<T> includeDeactiveRecords();
	
	
	String getHQLFrom();

	String getHQLBody();
	
	void fillParameters(Query query);
	
	public <ST,SC extends IStatCriteria<ST> > SC createStatCriteria(Class<SC> c);

}
