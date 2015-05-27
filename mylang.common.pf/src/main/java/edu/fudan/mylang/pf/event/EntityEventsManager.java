package edu.fudan.mylang.pf.event;

import java.util.Collection;

import edu.fudan.mylang.pf.IModelObject;

public abstract class EntityEventsManager<T extends IModelObject> implements IEntityEventsManager<T> {
	
	protected abstract Collection<? extends IEntityEventsListner<T>> getListeners();

	/* (non-Javadoc)
	 * @see edu.fudan.mylang.pf.event.IEntityEventsManager#fireCreated(T)
	 */
	@Override
	public void fireCreated(T entity) {
		for (IEntityEventsListner<T> listener : getListeners()) {
			listener.entityCreated(entity);
		}
	}

	/* (non-Javadoc)
	 * @see edu.fudan.mylang.pf.event.IEntityEventsManager#fireDeleted(T)
	 */
	@Override
	public void fireDeleted(T entity) {
		for (IEntityEventsListner<T> listener : getListeners()) {
			listener.entityDeleted(entity);
		}

	}
	/* (non-Javadoc)
	 * @see edu.fudan.mylang.pf.event.IEntityEventsManager#fireUpdateded(T)
	 */
	@Override
	public void fireUpdateded(T entity) {
		for (IEntityEventsListner<T> listener : getListeners()) {
			listener.entityUpdated(entity);
		}
		
	}

}
