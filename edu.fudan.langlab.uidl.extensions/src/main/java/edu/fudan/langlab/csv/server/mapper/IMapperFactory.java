package edu.fudan.langlab.csv.server.mapper;

import java.util.Collection;
import java.util.Date;

import com.uniquesoft.gwt.shared.GWTNamedEntity;

import edu.fudan.langlab.csv.server.mapper.MapperFactory.BooleanMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.CollectionMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.DateMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.DoubleMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.EnumMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.IntegerMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.LongMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.NamedEntityMapper;
import edu.fudan.langlab.csv.server.mapper.MapperFactory.StringMapper;

public interface IMapperFactory {

	@MapperTarget(Enum.class)
	public EnumMapper getEnumMapper(Class<? extends Enum> enumClass);

	@MapperTarget(Integer.class)
	public IntegerMapper getIntegerMapper();
	
	@MapperTarget(Long.class)
	public LongMapper getLongMapper();

	@MapperTarget(String.class)
	public StringMapper getStringMapper();

	@MapperTarget(Double.class)
	public DoubleMapper getDoubleMapper();

	@MapperTarget(Date.class)
	public DateMapper getDateMapper();

	@MapperTarget(Boolean.class)
	public BooleanMapper getBooleanMapper();
	
	@MapperTarget(GWTNamedEntity.class)
	public NamedEntityMapper getNamedEntityMapper();
	
	@MapperTarget(Collection.class)
	public CollectionMapper getCollectionMapper();

}
