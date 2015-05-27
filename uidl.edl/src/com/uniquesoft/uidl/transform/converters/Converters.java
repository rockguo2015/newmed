package com.uniquesoft.uidl.transform.converters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.datatype.File;
import com.uniquesoft.uidl.transform.IConverter;

import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import edu.fudan.mylang.pf.IObjectFactory;

public class Converters {

	@Component
	public static class EnumToEnumConverter implements IConverter<Enum, Enum> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return from.isEnum() && to.isEnum();
		}

		@Override
		public Enum toValue(Class<Enum> targetType, Enum value) {
			return Enum.valueOf(targetType, ((Enum) value).name());
		}
	}

	@Component
	public static class TimeStampToDateConverter implements
			IConverter<Timestamp, Date> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return from.equals(Timestamp.class) && to.equals(Date.class);
		}

		@Override
		public Date toValue(Class<Date> targetType, Timestamp value) {
			return new Date(value.getTime());
		}
	}

	@Component
	public static class FileToBlobConverter implements IConverter<File, Blob> {
		@Autowired
		IObjectFactory objectFactory;

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return from.equals(File.class) && to.equals(Blob.class);
		}

		@Override
		public Blob toValue(Class<Blob> targetType, File value) {
			try {
				Blob result = objectFactory
						.getHibernateSession()
						.getLobHelper()
						.createBlob(
								new FileInputStream(new java.io.File(
										value.getFullPathName())), -1);
				return result;
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

	}

	@Component
	public static class DateToTimestampConverter implements
			IConverter<Date, Timestamp> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return from.equals(Date.class) && to.equals(Timestamp.class);
		}

		@Override
		public Timestamp toValue(Class<Timestamp> targetType, Date value) {
			return new Timestamp(value.getTime());
		}
	}

	@Component
	public static class DateToSqlDateConverter implements
			IConverter<java.util.Date, java.sql.Date> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return from.equals(java.util.Date.class)
					&& to.equals(java.sql.Date.class);
		}

		@Override
		public java.sql.Date toValue(Class<java.sql.Date> targetType, Date value) {
			return new java.sql.Date(value.getTime());
		}
	}

	@Component
	public static class SqlDateToDateConverter implements
			IConverter<java.sql.Date, java.util.Date> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return from.equals(java.sql.Date.class)
					&& to.equals(java.util.Date.class);
		}

		@Override
		public Date toValue(Class<Date> targetType, java.sql.Date value) {
			return value;
		}

	}

	@Component
	public static class EntityToNamedEntityConverter implements
			IConverter<INamedModelObject, GWTNamedEntity> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return INamedModelObject.class.isAssignableFrom(from)
					&& GWTNamedEntity.class.isAssignableFrom(to);
		}

		@Override
		public GWTNamedEntity toValue(Class<GWTNamedEntity> targetType,
				INamedModelObject value) {
			GWTNamedEntity result = (GWTNamedEntity) ((IModelObject) value)
					.toProxy();
			result.setName(value.getEntityName());
			return result;
		}
	}

	@Component
	public static class NamedEntityToEntityConverter implements
			IConverter<GWTNamedEntity, IModelObject> {

		@Autowired
		private IObjectFactory objectFactory;

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return GWTNamedEntity.class.isAssignableFrom(from)
					&& IModelObject.class.isAssignableFrom(to);
		}

		@Override
		public IModelObject toValue(Class<IModelObject> targetType,
				GWTNamedEntity value) {
			return objectFactory.get(targetType, value.getId());
		}
	}

	@Component
	public static class ModelObjectToNamedEntityConverter implements
			IConverter<IModelObject, GWTNamedEntity> {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return IModelObject.class.isAssignableFrom(from)
					&& GWTNamedEntity.class.isAssignableFrom(to);
		}

		@Override
		public GWTNamedEntity toValue(Class<GWTNamedEntity> targetType,
				IModelObject value) {
			return (GWTNamedEntity) value.toProxy();
		}
	}

}
