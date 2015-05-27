package edu.fudan.mylang.pf.event;

import edu.fudan.mylang.pf.IModelObject;

public interface IEntityEventsManager<T extends IModelObject> {

	public abstract void fireCreated(T entity);

	public abstract void fireDeleted(T entity);

	public abstract void fireUpdateded(T entity);

}