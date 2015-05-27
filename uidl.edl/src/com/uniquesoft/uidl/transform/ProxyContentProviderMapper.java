package com.uniquesoft.uidl.transform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.uidl.naming.INameProvider;

import edu.fudan.mylang.pf.IModelObject;

@Service("ProxyContentProviderMapper")
public class ProxyContentProviderMapper<Entity extends IModelObject> extends
		AbstractMapper<GWTNamedEntity, Entity> {
	@Autowired
	INameProvider nameProvider;

	@Override
	public GWTNamedEntity buildFrom(Entity entity) {
		return (GWTNamedEntity)entity.toProxy();
	}

	@Override
	public void copyToEntity(GWTNamedEntity from, Entity to) {
		// proxy support one-way transformation only
		throw new UnsupportedOperationException();
	}

	@Override
	public GWTNamedEntity copyFromEntity(GWTNamedEntity gwtEntity, Entity entity) {
		gwtEntity.setId(entity.getId());
		gwtEntity.setName(nameProvider.getName(entity));
		return gwtEntity;
	}

}
