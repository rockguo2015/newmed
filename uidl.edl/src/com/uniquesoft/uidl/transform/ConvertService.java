package com.uniquesoft.uidl.transform;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.uniquesoft.gwt.shared.GWTEntity;
import com.uniquesoft.gwt.shared.GWTNamedEntity;

import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.IObjectFactory;


//@Service("ConvertService")
public class ConvertService implements IConvertService {

	@Autowired
	private Collection<IConverter> converters = new ArrayList<IConverter>();
	
	@Autowired
	private IObjectFactory objectFactory;	
	
	public IConverter getConverter(Class<?> from, Class<?> to) {
		if (from.equals(to))
			return IConverter.DefaultConverter;
		for (IConverter converter : converters) {
			if (converter.isAppliable(from, to)) {
				return converter;
			}
		}
		throw new RuntimeException(String.format(
				"converter not found from %s to %s.", from.getName(),
				to.getName()));
	}
	
	@Override
	public <From, To> To toValue(Class<To> targetType, From from) {
		if (from == null)
			return null;
		return (To) getConverter(from.getClass(), targetType).toValue(
				targetType, from);
	}

	@Override
	public <From, To> Collection<To> toCollectionValue(Class<To> targetType,
			Collection<From> from) {
		Collection<To> result = Lists.newArrayList();
		for (From item : from) {
			//performance !!!
			result.add(toValue(targetType, item));
		}
		return result;
	}

	@Override
	public <GwtEntity, Entity> GwtEntity toGwtEntity(Entity entity,
			AbstractMapper<GwtEntity, Entity> mapper) {
		return mapper.buildFrom(entity);
	}

	@Override
	public <GwtEntity, Entity> Entity toEntity(GwtEntity gwtEntity,
			Entity entity, AbstractMapper<GwtEntity, Entity> mapper) {
		mapper.copy(gwtEntity, entity);
		return entity;
	}

	@Override
	public <GwtEntity, Entity> Collection<GwtEntity> toGwtEntity(
			Collection<Entity> entities,
			AbstractMapper<GwtEntity, Entity> mapper) {
		Collection<GwtEntity> result = Lists.newArrayList();
		for (Entity entity : entities) {
			result.add(mapper.apply(entity));
		}
		return result;
	}

	

	@Override
	public <GwtDataType, DataType> Collection<DataType> toDataType(
			Collection<GwtDataType> gwtValues, Collection<DataType> values,
			AbstractDataTypeMapper<GwtDataType, DataType> mapper) {
		values.clear();
		for (GwtDataType gwtValue : gwtValues) {
			DataType value = mapper.create();
			mapper.copy(gwtValue, value);
			values.add(value);
		}
		return values;
	}



	
	@Override
	public <GwtEntity extends GWTEntity, Entity extends IModelObject> Collection<Entity> toPartEntity(
			final Collection<GwtEntity> gwtEntities, Collection<Entity> entities,
			AbstractEntityMapper<GwtEntity, Entity> mapper, Object context) {

		
		Iterables.removeIf(entities, new Predicate<Entity>() {
			@Override
			public boolean apply(@Nullable Entity input) {
				if(input==null) return false;
				for(GwtEntity gwtEntity : gwtEntities){
					if(Objects.equal(input.getId(),gwtEntity.getId())){
						return false;
					}
				}
				objectFactory.delete(input);
				return true;
			}
		});

		for (final GwtEntity gwtEntity : gwtEntities) {
			if (gwtEntity.getId() != null && gwtEntity.getId()>=0) {
				Entity targetEntity = IterableExtensions.findFirst(entities,
						new Functions.Function1<Entity, Boolean>() {
							@Override
							public Boolean apply(Entity entity) {
								return entity.getId().equals(gwtEntity.getId());
							}
						});
				mapper.copy(gwtEntity, targetEntity);
			} else {
				Entity targetEntity = mapper.create(gwtEntity, context);
				mapper.copy(gwtEntity, targetEntity);
				if(!entities.contains(targetEntity)){
					entities.add(targetEntity);
				}
			}
		}
		return entities;
	}
	
	public <Entity extends IModelObject> Collection<Entity> toProxyEntity(
			Collection<? extends GWTNamedEntity> gwtEntities, Collection<Entity> entities, Class<Entity> targetClass) {
		entities.clear();
		for(GWTNamedEntity gwtEntity : gwtEntities){
			entities.add(toValue(targetClass,gwtEntity));
		}
		return entities;
	}
	
	
	@Override
	public <GwtEntity extends GWTEntity, Entity extends IModelObject> Collection<Entity> toRefEntity(
			Collection<GwtEntity> gwtEntities, Collection<Entity> entities,
			AbstractEntityMapper<GwtEntity, Entity> mapper) {
		entities.clear();
		for (GwtEntity gwtEntity : gwtEntities) {
			Entity entity = mapper.loadEntityById(gwtEntity.getId());
			mapper.copy(gwtEntity, entity);
			entities.add(entity);
		}
		return entities;
	}
	
}
