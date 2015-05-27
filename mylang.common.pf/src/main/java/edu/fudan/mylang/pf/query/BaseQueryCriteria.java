package edu.fudan.mylang.pf.query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;

import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.pf.PersistenceException;

public abstract class BaseQueryCriteria<T> implements IQueryCriteria<T> {

	private OrderItem orderItem;
	private IObjectFactory objectFactory;
	private BeanFactory beanFactory;
	
	public void initialize(BeanFactory context){
		
	}
	public void postInitialize(){
		
	}
	private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();

	public IObjectFactory getObjectFactory() {
		return objectFactory;
	}

	public void setObjectFactory(IObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}
	
	public void setBeanFactory(BeanFactory beanFactory){
		this.beanFactory = beanFactory;
	}

	public BeanFactory getBeanFactory(){
		return beanFactory;
	}
	
	public OrderItem getOrderItem() {
		return orderItem;
	}

	protected Collection<OrderItem> getOrderItems() {
		return orderItems;
	}

	public IQueryCriteria<T> setOrder(String field, int order) {
		orderItem = new OrderItem(field, order);
		orderItems.add(orderItem);
		return this;
	}

	public IQueryCriteria<T> addOrder(String field, int order) {
		orderItems.add(new OrderItem(field, order));
		return this;
	}

	@Override
	public IQueryCriteria<T> addASC(String field) {
		return addOrder(field, OrderItem.ASC);
	}

	@Override
	public IQueryCriteria<T> addDESC(String field) {
		return addOrder(field, OrderItem.DESC);
	}

	protected Query createQuery(String hql) {
		return getObjectFactory().getHibernateSession().createQuery(hql);
	}

	protected List executeQuery(Query query) {
		return query.list();
	}

	protected Criteria crateCriteria(Class<? extends IModelObject> c) {
		return getObjectFactory().getHibernateSession().createCriteria(c);
	}

	protected Criteria buildAnnotationCriteria(IQueryCriteria<?> criteriaObject) {
		try {
			IQueryCriteria<?> queryCriteria = criteriaObject;
			Class<? extends IQueryCriteria<?>> queryCriteriaClass = (Class<? extends IQueryCriteria<?>>) criteriaObject
					.getClass();
			QueryCriteria queryCriteriaAnna = queryCriteriaClass
					.getAnnotation(QueryCriteria.class);

			Criteria criteria = crateCriteria(queryCriteriaAnna.entity());

			QueryAlias alias = queryCriteriaClass
					.getAnnotation(QueryAlias.class);
			if (alias != null) {
				for (String aliasItem : alias.name()) {
					criteria.createAlias(aliasItem, aliasItem.replace('.', '_'));
					// if (!aliasItem.contains(":"))
					// criteria.createAlias(aliasItem, aliasItem);
					// else
					// criteria.createAlias(aliasItem
					// .substring(0,aliasItem.indexOf(':')), aliasItem
					// .substring(aliasItem.indexOf(':')+1));
				}
			}

			Collection<Field> allFields = new ArrayList<Field>();
			collectAllFields(queryCriteriaClass, allFields);
			for (Field field : allFields) {
				QueryItem queryItem = field.getAnnotation(QueryItem.class);
				if (queryItem != null) {
					field.setAccessible(true);
					if (!QueryUtil.isNull(field.get(queryCriteria))) {
						criteria.add(createExpression(queryItem,
								field.get(queryCriteria)));
					}
				}
			}
			criteria.add(Restrictions.eq("active", true));
			if (!QueryUtil.isNull(getOrderItem())) {
				if (getOrderItem().getOrder() == OrderItem.ASC)
					criteria.addOrder(Order.asc(getOrderItem()
							.getPropertyName()));
				else {
					criteria.addOrder(Order.desc(getOrderItem()
							.getPropertyName()));
				}
			}
			return criteria;
		} catch (IllegalArgumentException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		}

	}

	private void collectAllFields(Class<?> clazz, Collection<Field> result) {
		for (Field field : clazz.getDeclaredFields())
			result.add(field);
		if (clazz.getSuperclass() != null) {
			collectAllFields(clazz.getSuperclass(), result);
		}
	}

	private Criterion createExpression(QueryItem queryItem, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		Criterion result = null;
		if (queryItem.type() == RestrictionType.eq) {
			result = Restrictions.eq(queryItem.attribute(), value);
		} else if (queryItem.type() == RestrictionType.like) {
			result = Restrictions
					.like(queryItem.attribute(), "%" + value + "%");
		} else if (queryItem.type() == RestrictionType.ge) {
			result = Restrictions.ge(queryItem.attribute(), value);
		} else if (queryItem.type() == RestrictionType.le) {
			result = Restrictions.le(queryItem.attribute(), value);
		} else if (queryItem.type() == RestrictionType.in) {
			result = Restrictions.in(queryItem.attribute(),
					(Collection<?>) value);
		} else
			throw new UnsupportedOperationException(queryItem.type().toString());
		if (queryItem.not()) {
			result = Restrictions.not(result);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> list() {
		Criteria hcriteria = buildAnnotationCriteria(this);
		return hcriteria.list();
	}

	public T uniqueResult() {
		Criteria hcriteria = buildAnnotationCriteria(this);
		return (T) hcriteria.uniqueResult();
	}

	public Integer count() {
		return (Integer) buildAnnotationCriteria(this).setProjection(
				Projections.rowCount()).uniqueResult();
	}
	
	
	
	public <ST,SC extends IStatCriteria<ST> > SC createStatCriteria(Class<SC> c){
		try {
			SC sc = c.newInstance();
			sc.setCriteria(this);
			sc.setObjectFactory(objectFactory);
			return sc;
		} catch (InstantiationException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		}
	}
	
}
