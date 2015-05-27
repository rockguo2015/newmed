package com.uniquesoft.uidl.transform;

/**
 * a converter convert a value of type "From" to value of type "To"
 * @author ztg
 *
 * @param <From>
 * @param <To>
 */
public interface IConverter<From, To> {
	
	boolean isAppliable(Class<?> from, Class<?> to);

	To toValue(Class<To> targetType, From value);

	IConverter<Object, Object> DefaultConverter = new IConverter<Object, Object>() {

		@Override
		public boolean isAppliable(Class<?> from, Class<?> to) {
			return true;
		}

		@Override
		public Object toValue(Class<Object> targetType, Object value) {
			return value;
		}

	};
}