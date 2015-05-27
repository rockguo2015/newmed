package com.uniquesoft.gwt.server.common.pager;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.IObjectNameFilter;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.common.pager.PagedResult;
import com.uniquesoft.uidl.transform.Mapper;

import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.IStatCriteria;

/**
 * This class contains static utility methods that operate on or return objects
 * of type {@link IPagedCriteria}. All the methods are used to implements the
 * page function in UIDL
 * 
 */
public class PagedQueries {
	/**
	 * Create an iterable {@code result} that applies {@code func} to each
	 * element of resource from {@code criteria}. Return the PagedResult that
	 * cheated according to the {@code criteria} and {@code func}
	 * 
	 * @param criteria
	 *            the page resource of type {@link IPagedCriteria}
	 * @param func
	 *            the transform rule
	 * @return the generate paged result
	 */
	public static <GWT, Entity> IPagedResult<GWT> listAndTransform(
			IPagedCriteria<Entity> criteria, Function<Entity, GWT> func) {
		Iterable<GWT> result = Iterables.transform(criteria.list(), func);
		int page = 0;
		if (criteria.getStart() != null && criteria.getLimit() != null)
			page = criteria.getStart() / criteria.getLimit() + 1;
		return new PagedResult<GWT>(page, criteria.count(),
				Lists.newArrayList(result));
	}
	public static <GWT, Entity> IPagedResult<GWT> listAndTransform(
			IStatCriteria<Entity> criteria, Function<Entity, GWT> func) {
		Iterable<GWT> result = Iterables.transform(criteria.list(), func);
		int page = 0;
		if (criteria.getFirstResult() != null && criteria.getMaxResult() != null)
			page = criteria.getFirstResult() / criteria.getMaxResult() + 1;
		return new PagedResult<GWT>(page, criteria.count(),
				Lists.newArrayList(result));
	}

	/**
	 * Returns the new criteria object of type {@link IPagedCriteria}
	 * 
	 * @param gwtPagedCriteria
	 *            the object of type {@link IPagedCriteria} contains page
	 *            information
	 * @param criteriaClass
	 *            the class type of the element in this page
	 * @param of
	 *            the object of type {@link IObjectFactory}
	 * @return the new created {@code pagedCriteria} of type
	 *         {@link IPagedCriteria}
	 */
	public static <S, T extends edu.fudan.mylang.pf.query.IPagedCriteria<S>> T createPagedCriteria(
			com.uniquesoft.gwt.shared.common.pager.IPagedCriteria gwtPagedCriteria,
			Class<T> criteriaClass, IObjectFactory of) {
		T pagedCriteria = of.createQueryCriteria(criteriaClass);
		if (gwtPagedCriteria.getPage() != null)
			pagedCriteria.setStart((gwtPagedCriteria.getPage() - 1)
					* gwtPagedCriteria.getPageSize());
		if (gwtPagedCriteria.getPageSize() != null)
			pagedCriteria.setLimit(gwtPagedCriteria.getPageSize());
		return pagedCriteria;
	}

	public static <S, T extends edu.fudan.mylang.pf.query.IPagedCriteria<S>> T createCriteria4All(
			com.uniquesoft.gwt.shared.common.pager.IPagedCriteria gwtPagedCriteria,
			Class<T> criteriaClass, IObjectFactory of) {
		T pagedCriteria = of.createQueryCriteria(criteriaClass);
		return pagedCriteria;
	}

	/**
	 * 
	 * @param gwtPagedCriteria
	 *            the object of type {@link IPagedCriteria} contains page
	 *            information
	 * @param criteriaClass
	 *            the class type of the element in this page
	 * @param mapper
	 *            mappings to transform {@link IPagedCriteria}
	 * @param of
	 *            the object of type {@link IObjectFactory}
	 * @return the transformed object of {@link IPagedCriteria}
	 */
	public static <GT extends com.uniquesoft.gwt.shared.common.pager.IPagedCriteria, S, T extends edu.fudan.mylang.pf.query.IPagedCriteria<S>> T createPagedCriteria(
			GT gwtPagedCriteria, Class<T> criteriaClass, Mapper<GT, T> mapper,
			IObjectFactory of) {
		T pagedCriteria = of.createQueryCriteria(criteriaClass);
		if (gwtPagedCriteria.getPage() != null
				&& gwtPagedCriteria.getPageSize() != null)
			pagedCriteria.setStart((gwtPagedCriteria.getPage() - 1)
					* gwtPagedCriteria.getPageSize());
		if (gwtPagedCriteria.getPageSize() != null)
			pagedCriteria.setLimit(gwtPagedCriteria.getPageSize());
		mapper.transform(gwtPagedCriteria, pagedCriteria);
		return pagedCriteria;
	}
	public static <GT extends com.uniquesoft.gwt.shared.common.pager.IPagedCriteria, S, T extends edu.fudan.mylang.pf.query.IPagedCriteria<S>> T createCriteria4All(
			GT gwtPagedCriteria, Class<T> criteriaClass, Mapper<GT, T> mapper,
			IObjectFactory of) {
		T pagedCriteria = of.createQueryCriteria(criteriaClass);
		mapper.transform(gwtPagedCriteria, pagedCriteria);
		return pagedCriteria;
	}

}
