package edu.fudan.langlab.csv.server.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import com.uniquesoft.gwt.shared.datatype.IUIDLEnum;

import edu.fudan.langlab.csv.shared.IFieldValidationResultAcceptor;

@Component("edu.fudan.langlab.gxt.server.csv.mapper.MapperFactory")
public class MapperFactory implements IMapperFactory {

	public static class EnumMapper implements ICSVItemMapper<Enum> {
		private Class<? extends Enum> enumClass;

		public EnumMapper(Class<? extends Enum> enumClass) {
			this.enumClass = enumClass;
		}

		@Override
		public String toString(Enum data) {
			if (data == null)
				return "";
			return data.toString();
		}

		@Override
		public Enum fromString(String s, IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;
			Enum result = ((IUIDLEnum) enumClass.getEnumConstants()[0])
					.fromString(s);
			if (result == null) {
				acceptor.accept("输入值无效");
				return null;
			} else
				return result;
		}

	}

	public static class BooleanMapper implements ICSVItemMapper<Boolean> {

		@Override
		public String toString(Boolean data) {
			if (data == null)
				return "";
			return data ? "是" : "否";
		}

		@Override
		public Boolean fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;

			if ("是".equals(s))
				return true;
			else if ("否".equals(s))
				return false;
			else
				acceptor.accept("无效值，请输入‘是’/‘否’");
			return null;
		}
	}

	public static class IntegerMapper implements ICSVItemMapper<Integer> {

		@Override
		public String toString(Integer value) {
			if (value == null)
				return "";
			return value.toString();
		}

		@Override
		public Integer fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException n) {
				acceptor.accept("无效整数");
				return null;
			}
		}

	}
	public static class LongMapper implements ICSVItemMapper<Long> {

		@Override
		public String toString(Long value) {
			if (value == null)
				return "";
			return value.toString();
		}

		@Override
		public Long fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;
			try {
				return Long.parseLong(s);
			} catch (NumberFormatException n) {
				acceptor.accept("无效整数");
				return null;
			}
		}

	}
	
	public static class StringMapper implements ICSVItemMapper<String> {

		@Override
		public String toString(String value) {
			if (value == null)
				return "";
			if (value.contains(",") || value.contains("，"))
				return "\"" + value.toString() + "\"";
			else
				return value.toString();
		}

		@Override
		public String fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;
			return s;
		}
	}

	public static class DoubleMapper implements ICSVItemMapper<Double> {

		@Override
		public String toString(Double value) {
			if (value == null)
				return "";
			return value.toString();
		}

		@Override
		public Double fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;
			try {
				return Double.parseDouble(s);
			} catch (NumberFormatException e) {
				acceptor.accept("无效浮点数类型");
				return null;
			}
		}
	}

	public class DateMapper implements ICSVItemMapper<Date> {

		@Override
		public String toString(Date value) {
			if (value == null)
				return "";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return format.format(value);
		}

		@Override
		public Date fromString(String s, IFieldValidationResultAcceptor acceptor) {
			if (StringExtensions.isNullOrEmpty(s))
				return null;
			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				return format.parse(s);
			} catch (ParseException e1) {

				try {
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
					return format.parse(s);
				} catch (ParseException e2) {
					acceptor.accept("无效日期类型(yyyy-MM-dd)或(yyyy/MM/dd)");
					return null;
				}
			}
		}

	}

	public class NamedEntityMapper implements ICSVItemMapper<GWTNamedEntity> {

		@Override
		public String toString(GWTNamedEntity data) {
			System.out.println(data);
			if (data != null)
				return data.getName();
			else
				return "";
		}

		@Override
		public GWTNamedEntity fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			throw new UnsupportedOperationException();
		}

	}

	public class CollectionMapper implements ICSVItemMapper<Collection<?>> {

		@Override
		public String toString(Collection<?> data) {
			Iterable<String> strings = IterableExtensions.map(data,
					new Function1<Object, String>() {

						@Override
						public String apply(Object p) {
							if (p instanceof GWTNamedEntity) {
								return ((GWTNamedEntity) p).getName();
							} else
								return p.toString();
						}
					});
			String value = IterableExtensions.join(strings, ",");

			if (value.contains(",") || value.contains("，"))
				return "\"" + value.toString() + "\"";
			return value;
		}

		@Override
		public Collection<?> fromString(String s,
				IFieldValidationResultAcceptor acceptor) {
			throw new UnsupportedOperationException();
		}

	}

	public IntegerMapper getIntegerMapper() {
		return new IntegerMapper();
	}
	public LongMapper getLongMapper() {
		return new LongMapper();
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

	@Override
	public EnumMapper getEnumMapper(Class<? extends Enum> enumClass) {
		return new EnumMapper(enumClass);
	}

	@Override
	public NamedEntityMapper getNamedEntityMapper() {
		return new NamedEntityMapper();
	}

	@Override
	public CollectionMapper getCollectionMapper() {
		return new CollectionMapper();
	}

}
