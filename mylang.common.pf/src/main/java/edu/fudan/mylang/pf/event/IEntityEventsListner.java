package edu.fudan.mylang.pf.event;

import edu.fudan.mylang.pf.IModelObject;

public interface IEntityEventsListner<T extends IModelObject> {

	void entityCreated( T newEntity);
	void entityDeleted(T entityToBeDeleted);
	void entityUpdated(T updatedEntity);
	
}
