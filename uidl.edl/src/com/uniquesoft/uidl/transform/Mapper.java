package com.uniquesoft.uidl.transform;

import com.google.common.base.Function;

/**
 * Provider methods to convert the objects between model and view
 *
 * @param <GWTEntity>
 * @param <Entity>
 */
public interface Mapper<GWTEntity, Entity> extends Function<Entity, GWTEntity> {
	
	/**
	 * @param from an data in Client side
	 * @param to an data in server side
	 * @return the data in server side with the same value as client side data
	 */
	public Entity copy(GWTEntity from, Entity to);

	/**
	 * @param entity
	 * @return transfer the data in server side to a client data type
	 */
	public GWTEntity build(Entity entity);
	
	/**
	 * @param from data in client side
	 * @param to data in server side
	 * @return  transfer the client side data to server side data, and return it 
	 */
	public Entity transform(GWTEntity from, Entity to);
	
	/**
	 * transfer the server side data to client side data
	 * @param entity
	 * @return client side data type
	 */
	public GWTEntity transform(Entity entity);
	
}
