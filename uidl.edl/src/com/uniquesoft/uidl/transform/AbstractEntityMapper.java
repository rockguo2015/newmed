package com.uniquesoft.uidl.transform;

import com.uniquesoft.gwt.shared.GWTEntity;


public abstract class AbstractEntityMapper<GwtEntity extends GWTEntity, Entity extends Object>
		extends AbstractMapper<GwtEntity, Entity> {

	public abstract Entity loadEntityById(Long id);
	
	public abstract Entity create();

	public Entity create(GwtEntity gwtEntity, Object context) {
		throw new UnsupportedOperationException();
	}
}
