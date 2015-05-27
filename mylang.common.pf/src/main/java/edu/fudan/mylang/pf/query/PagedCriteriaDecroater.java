package edu.fudan.mylang.pf.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.Query;
import org.springframework.beans.factory.BeanFactory;

import com.google.common.collect.Iterables;

public class PagedCriteriaDecroater<T> implements IPagedCriteria<T> {

	public interface ISelecter<T> {
		boolean select(T candidate);
	}

	private IQueryCriteria<T> queryCriteria;
	private ISelecter<T> selecter;
	private OrderItem orderItem;
	private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();
	private Integer limit;
	private Integer start;

	public PagedCriteriaDecroater(IQueryCriteria<T> queryCriteria,
			ISelecter<T> selecter) {
		this.queryCriteria = queryCriteria;
		this.selecter = selecter;

	}

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

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public IQueryCriteria<T> setOrder(String field, int order) {
		orderItem = new OrderItem(field, order);
		orderItems.add(orderItem);
		return this;

	}

	@Override
	public IQueryCriteria<T> addOrder(String field, int order) {
		orderItem = new OrderItem(field, order);
		orderItems.add(orderItem);
		return this;
	}

	public Integer count() {
		Iterator<T> rawResult = queryCriteria.list().iterator();
		int curCount = 0;
		while (rawResult.hasNext()) {

			T currentObject = rawResult.next();
			if (selecter.select(currentObject)) {
				curCount++;
				continue;
			}
		}
		return curCount;
	}

	public Collection<T> list() {
		// TODO backup and restore old criteria
		if (orderItem != null)
			queryCriteria.setOrder(orderItem.getPropertyName(),
					orderItem.getOrder());
		Iterator<T> rawResult = queryCriteria.list().iterator();
		Collection<T> result = new ArrayList<T>();
		int index = 0, curCount = 0;
		while (limit == null || curCount < limit) {
			if (!rawResult.hasNext())
				break;
			T currentObject = rawResult.next();
			if (!selecter.select(currentObject))
				continue;
			if (start != null && index++ < start) {
				continue;
			} else {
				result.add(currentObject);
				curCount++;
			}
		}
		return result;
	}

	public T uniqueResult() {
		return Iterables.getOnlyElement(list());
	}

	@Override
	public IQueryCriteria<T> includeDeactiveRecords() {
		return this;

	}

	@Override
	public void deleteAll() {
		queryCriteria.deleteAll();
	}

	@Override
	public IQueryCriteria<T> addASC(String field) {
		return addOrder(field, OrderItem.ASC);
	}

	@Override
	public IQueryCriteria<T> addDESC(String field) {
		return addOrder(field, OrderItem.DESC);
	}

	@Override
	public void initialize(BeanFactory context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInitialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <ST, SC extends IStatCriteria<ST>> SC createStatCriteria(Class<SC> c) {
		// TODO Auto-generated method stub
		return null;
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
