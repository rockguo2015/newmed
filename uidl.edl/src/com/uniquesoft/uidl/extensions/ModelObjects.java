package com.uniquesoft.uidl.extensions;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.IGWTEntity;
import com.uniquesoft.gwt.shared.adaptor.EntityAdaptorProxy;

import edu.fudan.mylang.pf.EntityAdaptor;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.pf.PersistenceException;

@SuppressWarnings("all")
public class ModelObjects {

	public static <T extends IModelObject> T resolve(IObjectFactory entities,
			GWTNamedEntity proxy, Class<T> type) {
		if (proxy == null)
			return null;
		T result = entities.get(type, proxy.getId());
		if (result == null)
			throw new PersistenceException("unexisting proxy object");
		return result;
	}

	public static Object resolve(IGWTEntity gwtEntity, IObjectFactory entities) {
		try {
			if (gwtEntity == null)
				return null;
			if (gwtEntity instanceof EntityAdaptorProxy) {
				return resolveAdaptor(gwtEntity, entities);
			} else
				return (IModelObject) entities.get((Class<IModelObject>) Class
						.forName(gwtEntity.getClazzName()), gwtEntity.getId());
		} catch (ClassNotFoundException e) {
			throw new PersistenceException(e);
		}
	}

	public static <T extends IModelObject> T create(IObjectFactory entities,
			Class<T> objType) {
		EntityImplementation entityImplAnnotation = objType
				.getAnnotation(EntityImplementation.class);
		Class<? extends IModelObject> entityType = entityImplAnnotation
				.implementBy();
		try {
			IModelObject entityInstance = entityType.newInstance();
			return (T) entities.create(entityInstance);
		} catch (InstantiationException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		}
	}

	public static Object resolveAdaptor(IGWTEntity proxy,
			IObjectFactory entities) {
		try {
			EntityAdaptor adaptor = (EntityAdaptor) Class.forName(
					proxy.getClazzName()).newInstance();
			adaptor.setAdaptee(resolve(
					((EntityAdaptorProxy) proxy).getAdapteeProxy(), entities));
			adaptor.setObjectFactory(entities);
			adaptor.setBeanFactory(entities.getBeanFactory());
			return adaptor;
		} catch (InstantiationException e) {
			throw new PersistenceException(e);
		} catch (IllegalAccessException e) {
			throw new PersistenceException(e);
		} catch (ClassNotFoundException e) {
			throw new PersistenceException(e);
		}
	}

}
