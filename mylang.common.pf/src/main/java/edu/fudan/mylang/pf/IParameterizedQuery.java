package edu.fudan.mylang.pf;

import java.util.Collection;

public interface IParameterizedQuery<T> extends
		IGenericQuery<T> {
	
	IParameterizedQuery<T> setParameter(String paramName, Object value);

	IParameterizedQuery<T> setParameterList(String name, Collection<?> vals);
}
