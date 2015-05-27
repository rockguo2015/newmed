package com.uniquesoft.uidl.transform;

/**
 * This class is used to unify several methods that have the same function, for the
 *  history version reason, we used copy, copyTo,transform and so on to transfer a GWTEntity to Entity,
 *  now ,we just need to remember "transfer" method.
 *
 * @param <GWTEntity>
 * @param <Entity>
 */
public abstract class AbstractMapper<GWTEntity, Entity> implements
		Mapper<GWTEntity, Entity> {

	/* (non-Javadoc)
	 * @see com.uniquesoft.uidl.transform.Mapper#copy(java.lang.Object, java.lang.Object)
	 * It just calls the copyToEntity() method to do the 
	 */
	public Entity copy(GWTEntity from, Entity to) {
		copyToEntity(from, to);
		return to;
	}

	abstract public void copyToEntity(GWTEntity gwtEntity, Entity entity);
	
	abstract public GWTEntity copyFromEntity( GWTEntity gwtEntity, Entity entity);

	@Override
	public GWTEntity apply(Entity entity) {
		return build(entity);
	}

	public GWTEntity build(Entity entity) {
		return buildFrom(entity);
	}

	abstract public GWTEntity buildFrom(Entity entity);
	
	@Override
	public Entity transform(GWTEntity from, Entity to) {
		return copy(from,to);
	}

	@Override
	public GWTEntity transform(Entity entity) {
		if(entity==null) return null;
		return build(entity);
	}
}
