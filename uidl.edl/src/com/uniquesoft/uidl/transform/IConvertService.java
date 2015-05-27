package com.uniquesoft.uidl.transform;

import java.util.Collection;

import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

import edu.fudan.mylang.pf.IModelObject;


public interface IConvertService {

	public <From, To> To toValue(Class<To> targetType, From value);

	public <GwtEntity, Entity> GwtEntity toGwtEntity(Entity entity,
			AbstractMapper<GwtEntity, Entity> mapper);

	public <GwtEntity, Entity> Collection<GwtEntity> toGwtEntity(
			Collection<Entity> entity, AbstractMapper<GwtEntity, Entity> mapper);

	public <From, To> Collection<To> toCollectionValue(Class<To> targetType,
			Collection<From> noticeItems);

	public <GwtEntity, Entity> Entity toEntity(GwtEntity gwtEntity,
			Entity entity, AbstractMapper<GwtEntity, Entity> mapper);


	public <GwtEntity, Entity> Collection<Entity> toDataType(
			Collection<GwtEntity> gwtEntity, Collection<Entity> entity,
			AbstractDataTypeMapper<GwtEntity, Entity> mapper);

	public <GwtEntity extends GWTEntity, Entity extends IModelObject> Collection<Entity> toPartEntity(
			Collection<GwtEntity> gwtEntity, Collection<Entity> entity,
			AbstractEntityMapper<GwtEntity, Entity> mapper, Object context);

	public <GwtEntity extends GWTEntity, Entity extends IModelObject> Collection<Entity> toRefEntity(
			Collection<GwtEntity> gwtEntity, Collection<Entity> entity,
			AbstractEntityMapper<GwtEntity, Entity> mapper);


	public <Entity extends IModelObject> Collection<Entity> toProxyEntity(
			Collection<? extends GWTNamedEntity> gwtEntities,
			Collection<Entity> entities, Class<Entity> targetClass);
}