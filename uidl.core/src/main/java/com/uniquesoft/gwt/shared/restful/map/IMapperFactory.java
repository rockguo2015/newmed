package com.uniquesoft.gwt.shared.restful.map;

import java.util.Date;

import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.shared.restful.map.MapperFactory.BooleanMapper;
import com.uniquesoft.gwt.shared.restful.map.MapperFactory.DateMapper;
import com.uniquesoft.gwt.shared.restful.map.MapperFactory.DoubleMapper;
import com.uniquesoft.gwt.shared.restful.map.MapperFactory.IntegerMapper;
import com.uniquesoft.gwt.shared.restful.map.MapperFactory.StringMapper;


@ImplementedBy(MapperFactory.class)
public interface IMapperFactory {

	@MapperTarget(Integer.class)
	public IntegerMapper getIntegerMapper();

	@MapperTarget(String.class)
	public StringMapper getStringMapper();
	
	@MapperTarget(Double.class)
	public DoubleMapper getDoubleMapper();
	
	@MapperTarget(Date.class)
	public DateMapper getDateMapper();
	
	@MapperTarget(Boolean.class)
	public BooleanMapper getBooleanMapper();

}
