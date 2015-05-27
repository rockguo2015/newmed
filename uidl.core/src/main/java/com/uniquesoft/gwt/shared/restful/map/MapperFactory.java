package com.uniquesoft.gwt.shared.restful.map;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONValue;

public class MapperFactory implements IMapperFactory {
	
	public static class BooleanMapper extends BaseJsonMapper<Boolean> {
		@Override
		public Boolean fromJson(JSONValue value) {
			return value.isBoolean().booleanValue();
		}

		@Override
		public String toString(Boolean value) {
			if(value==null) return "null";
			return value.toString();
		}


	}	
	
	public static class IntegerMapper extends BaseJsonMapper<Integer> {
		@Override
		public Integer fromJson(JSONValue value) {
			return (int) value.isNumber().doubleValue();
		}

		@Override
		public String toString(Integer value) {
			if(value==null) return "null";
			return value.toString();
		}


	}

	public static class StringMapper extends BaseJsonMapper<String> {
		@Override
		public String fromJson(JSONValue value) {
			return value.isString().stringValue();
		}

		@Override
		public String toString(String value) {
			if(value==null) return "null";
			return value.toString();
		}
	}

	public static class DoubleMapper extends BaseJsonMapper<Double> {
		@Override
		public Double fromJson(JSONValue value) {
			return value.isNumber().doubleValue();
		}

		@Override
		public String toString(Double value) {
			if(value==null)return "null";
			return value.toString();
		}
	}

	public class DateMapper extends BaseJsonMapper<Date> {

		@Override
		public Date fromJson(JSONValue value) {
			DateTimeFormat format = DateTimeFormat.getFormat("yyyy/MM/dd");
			return format.parse(value.isString().stringValue());
		}

		@Override
		public String toString(Date value) {
			if(value==null) return "null";
			DateTimeFormat format = DateTimeFormat.getFormat("yyyy/MM/dd");
			return format.format(value);
		}

	}

	public IntegerMapper getIntegerMapper() {
		return new IntegerMapper();
	}

	@Override
	public StringMapper getStringMapper() {
		return new StringMapper();
	}

	@Override
	public DoubleMapper getDoubleMapper() {
		return new DoubleMapper();
	}

	@Override
	public DateMapper getDateMapper() {
		return new DateMapper();
	}

	@Override
	public BooleanMapper getBooleanMapper() {
		return new BooleanMapper();
	}
}
