/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package edu.fudan.mylang.pf;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.fudan.mylang.pf.query.BaseQueryCriteria;
import edu.fudan.mylang.pf.query.IQueryCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

/**
 * A hibernate/Spring framework implementation for IObjectFactory
 * 
 * @author zhang tiange
 * 
 */
@Transactional(propagation = Propagation.REQUIRED)
public class ObjectFactoryHibernateImpl extends HibernateDaoSupport implements IObjectFactory, BeanFactoryAware {

	BeanFactory beanFactory;

	private Class getImplClass(Class clazz) {
		if (clazz.isInterface()) {
			EntityImplementation impl = (EntityImplementation) clazz.getAnnotation(EntityImplementation.class);
			return impl.implementBy();
		} else
			return clazz;
	}

	private String getBeanID(Class clazz) {
		int pos = clazz.getName().lastIndexOf('.') + 1;
		return clazz.getName().substring(pos);
	}

	public IModelObject create(IModelObject obj) {
		((BaseModelObject) obj).preinitialize();
		getSession().saveOrUpdate(obj);
		((BaseModelObject) obj).setObjectFactory((IObjectFactory) beanFactory.getBean("objectFactory"));
		((BaseModelObject) obj).entityInitialized(beanFactory);
		for (IPersistenceEventListener listener : listeners) {
			try {
				listener.afterObjectSaved(obj, this);
			} catch (Exception e) {
				// TODO fixme
			}
		}
		return obj;
	}

	public <T extends IModelObject> T get(Class<T> clazz, Serializable id) {
		IModelObject bean = (IModelObject) getHibernateTemplate().get(getImplClass(clazz), id);
		return (T) bean;
	}

	public IModelObject load(IModelObject e) {
		getHibernateTemplate().load(e, e.getId());
		return e;
	}

	public void delete(IModelObject obj) {
		getHibernateTemplate().delete(obj);
	}

	public void save(IModelObject obj) {
		getSession().saveOrUpdate(obj);
		if (obj instanceof IContextAwareModelObject) {
			((IContextAwareModelObject) obj).setObjectFactory((IObjectFactory) beanFactory.getBean("objectFactory"));
			((IContextAwareModelObject) obj).entityInitialized(beanFactory);
		}
	}

	public <T extends IModelObject> Collection<T> all(Class<T> clazz) {
		Class c = getImplClass(clazz);
		return getHibernateTemplate().find("from " + c.getName() + " where active = 1 ");
	}

	@Override
	public <T extends IModelObject> Collection<T> allWithDeactived(Class<T> clazz) {
		Class c = getImplClass(clazz);
		return getHibernateTemplate().find("from " + c.getName());
	}

	public boolean exist(IModelObject value) {
		throw new RuntimeException("not supported");
	}

	public void setBeanFactory(BeanFactory appContext) throws BeansException {
		this.beanFactory = appContext;

	}

	public void deleteAll(Class<? extends IModelObject> clazz) {
		getHibernateTemplate().deleteAll(all(clazz));
	}

	public Criteria createCriteria(Class<? extends IModelObject> clazz) {
		return getHibernateSession().createCriteria(clazz);
	}

	public void save(IModelObject model, Serializable id) {
		// getSession().persist(model, id);

	}

	public Session getHibernateSession() {
		return getSession();
	}

	public void logicDelete(IModelObject modelObject) {
		modelObject.setIsActive(false);
		save(modelObject);
	}

	public Set<IPersistenceEventListener> getPersistenceEventListeners() {
		return listeners;
	}

	public void setPersistenceEventListeners(Set<IPersistenceEventListener> listeners) {
		this.listeners = listeners;

	}

	Set<IPersistenceEventListener> listeners = new HashSet<IPersistenceEventListener>();

	@Override
	public Query createQuery(String hql) {
		return getHibernateSession().createQuery(hql);
	}

	public <S, T extends IQueryCriteria<S>> T createQueryCriteria(Class<T> c) {
		Annotation[] result = c.getAnnotations();
		QueryImplementation impl = c.getAnnotation(QueryImplementation.class);
		try {
			BaseQueryCriteria queryCriteria = (BaseQueryCriteria) impl.implementBy().newInstance();
			queryCriteria.setObjectFactory(this);
			return (T) queryCriteria;
		} catch (InstantiationException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public <M> Iterable<M> executeQuery(Query query) {
		return (Iterable<M>) query.list();
	}

	@Override
	public <T> IParameterizedQuery<T> createGenericQuery(Class<T> type, String hql) {
		return new GenericQueryImpl<T>(this, hql);
	}
	@Override
	public IParameterizedQuery<Map<String, Object>> createMapQuery(String hql) {
		return new MapQueryImpl(this,hql);
	}
	@Override
	public void addPersistenceEventListeners(IPersistenceEventListener listener) {
		listeners.add(listener);

	}

//	@Override
	public <T extends IModelObject> T create(Class<T> objType) {
		EntityImplementation entityImplAnnotation = objType
				.getAnnotation(EntityImplementation.class);
		Class<? extends IModelObject> entityType = entityImplAnnotation
				.implementBy();
		try {
			IModelObject entityInstance = entityType.newInstance();
			return (T)create(entityInstance);
		} catch (InstantiationException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		}
	}

	@Override
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}



}
