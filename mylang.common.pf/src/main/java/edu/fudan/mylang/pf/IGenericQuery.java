package edu.fudan.mylang.pf;

import java.util.Collection;

public interface IGenericQuery<T> {

	Collection<T> list();

	T uniqueResult();

	IGenericQuery<T> setMaxResults(int maxResults);

}
