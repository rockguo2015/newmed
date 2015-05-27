package edu.fudan.mylang.pf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;

import edu.fudan.mylang.pf.query.IQueryCriteria;

public class ObjectFactoryDummyImpl implements IObjectFactory {

	@Override
	public <T extends IModelObject> T create(Class<T> objType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModelObject create(IModelObject object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IModelObject> T get(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModelObject load(IModelObject e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(IModelObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logicDelete(IModelObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Class<? extends IModelObject> clazz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(IModelObject obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(IModelObject obj, Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends IModelObject> Collection<T> all(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IModelObject> Collection<T> allWithDeactived(
			Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exist(IModelObject value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Session getHibernateSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<IPersistenceEventListener> getPersistenceEventListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPersistenceEventListeners(
			Set<IPersistenceEventListener> listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPersistenceEventListeners(IPersistenceEventListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Query createQuery(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> IParameterizedQuery<T> createGenericQuery(Class<T> type,
			String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IParameterizedQuery<Map<String, Object>> createMapQuery(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <M> Iterable<M> executeQuery(Query query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S, T extends IQueryCriteria<S>> T createQueryCriteria(Class<T> c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanFactory getBeanFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
