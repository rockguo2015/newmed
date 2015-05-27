package edu.fudan.mylang.pf.event;

import edu.fudan.mylang.pf.BaseService;
import edu.fudan.mylang.pf.IModelObject;

public class BaseEntityEventsListener<T extends IModelObject> extends
		BaseService implements IEntityEventsListner<T> {

	@Override
	public void entityCreated(T newEntity) {

	}

	@Override
	public void entityDeleted(T entityToBeDeleted) {

	}

	@Override
	public void entityUpdated(T updatedEntity) {
	}

}
