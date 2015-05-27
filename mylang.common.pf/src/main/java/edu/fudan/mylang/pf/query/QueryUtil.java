package edu.fudan.mylang.pf.query;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import edu.fudan.mylang.pf.ILiterialEnum;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.IObjectFactory;

public class QueryUtil {
	public static boolean isNull(Object obj) {
		if(obj==null)
			return true;
		if (obj instanceof Collection)
			return ((Collection<?>) obj).isEmpty();
		if (obj instanceof Integer)
			return  (Integer) obj == -1;
		if(obj instanceof String)
			return isEmpty((String)obj);
		return false;
	}

	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	public static int getQueryCount(IObjectFactory objectFactory,
			Criteria criteria) {
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}

	public static Collection<?> getPagedQueryResult(IObjectFactory objectFactory,
			Criteria hcriteria, IPagedCriteria<?> pagedCriteria) {

		if (!isNull(pagedCriteria.getLimit()))
			hcriteria.setMaxResults(pagedCriteria.getLimit());
		if (!isNull(pagedCriteria.getStart()))
			hcriteria.setFirstResult(pagedCriteria.getStart());
		if (!isNull(pagedCriteria.getOrderItem())) {
			if (pagedCriteria.getOrderItem().getOrder() == OrderItem.ASC)
				hcriteria.addOrder(Order.asc(pagedCriteria.getOrderItem()
						.getPropertyName()));
			else {
				hcriteria.addOrder(Order.desc(pagedCriteria.getOrderItem()
						.getPropertyName()));
			}
		}
		return hcriteria.list();
	}

	public static String buildCollectionValues(Collection<?> list) {
		String result = "(";
		boolean isFirst = true;
		for (Object o : list) {
			if (isFirst) {
				result += toString(o);
				isFirst = false;
			} else {
				result += ',' + toString(o);
			}
		}
		result += ")";

		return result;
	}

	private static String toString(Object o) {
		if (o instanceof String) {
			return "'" + o.toString() + "'";
		} else if (o instanceof ILiterialEnum) {
			return "'" + ((ILiterialEnum) o).toLiteral() + "'";
		} else if (o instanceof IModelObject)
			return ((IModelObject) o).getId().toString();
		else
			return o.toString();
	}
}
