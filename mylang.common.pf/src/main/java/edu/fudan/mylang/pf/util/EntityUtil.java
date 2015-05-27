package edu.fudan.mylang.pf.util;

import edu.fudan.mylang.pf.EntityImplementation;

public class EntityUtil {
	public static Class getImplClass(Class clazz) {
		if (clazz.isInterface()) {
			EntityImplementation impl = (EntityImplementation) clazz
					.getAnnotation(EntityImplementation.class);
			return impl.implementBy();
		} else
			return clazz;
	}
}
