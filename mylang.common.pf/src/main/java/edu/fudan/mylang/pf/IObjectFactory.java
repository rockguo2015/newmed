/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package edu.fudan.mylang.pf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;

import edu.fudan.mylang.pf.query.IQueryCriteria;

/**
 * Object Factory is used to process o-r mapping for model objects
 * 
 * @author zhangtiange
 */
public interface IObjectFactory {

	<T extends IModelObject>  T create(Class<T> objType);
	
	IModelObject create(IModelObject object);
	/**
	 * load a persistened object
	 * 
	 * @param <E>
	 * @param clazz
	 *            type of persistened object
	 * @param id
	 *            object ID
	 * @return result object
	 */
	<T extends IModelObject> T get(Class<T> clazz, Serializable id);

	/**
	 * load the model object and synchronize the object with DB
	 * 
	 * @param e
	 * @return the loaded model object
	 */
	IModelObject load(IModelObject e);

	/**
	 * delete the model object
	 * 
	 * @param obj
	 */
	void delete(IModelObject obj);

	/**
	 * logic delete the model object
	 * 
	 * @param obj
	 */
	void logicDelete(IModelObject obj);

	/**
	 * delete all the model object of specified type
	 * 
	 * @param clazz
	 */
	void deleteAll(Class<? extends IModelObject> clazz);

	/**
	 * save the model object
	 * 
	 * @param obj
	 */
	void save(IModelObject obj);

	/**
	 * save the model object with specified id
	 * 
	 * @param obj
	 * @param id
	 */
	void save(IModelObject obj, Serializable id);

	/**
	 * get all objects of specified type
	 * 
	 * @param clazz
	 * @return
	 */
	<T extends IModelObject> Collection<T> all(Class<T> clazz);
	
	<T extends IModelObject> Collection<T> allWithDeactived(Class<T> clazz);

	/**
	 * check if the specified object is exist
	 * 
	 * @param value
	 * @return
	 */
	boolean exist(IModelObject value);

	/**
	 * get hibernate session
	 * 
	 * @return Hibernate Session
	 */
	Session getHibernateSession();

	/**
	 * get the persistence listeners
	 * 
	 * @return the persistence listeners
	 */
	Set<IPersistenceEventListener> getPersistenceEventListeners();

	/**
	 * set the persistence listeners
	 * 
	 * @param listeners
	 *            the persistence listeners
	 */
	void setPersistenceEventListeners(Set<IPersistenceEventListener> listeners);
	
	void addPersistenceEventListeners(IPersistenceEventListener listener);
	
	Query createQuery(String hql);
	
	<T> IParameterizedQuery<T> createGenericQuery(Class<T> type, String hql);
	
	IParameterizedQuery<Map<String,Object>> createMapQuery(String hql);
	
	<M> Iterable<M> executeQuery(Query query);
	
	public <S, T extends IQueryCriteria<S>> T createQueryCriteria(Class<T> c);
	
	BeanFactory getBeanFactory();

}
