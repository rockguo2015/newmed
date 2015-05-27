package com.fudanmed.platform.core.domain.impl;

import java.util.Collection;

import org.hibernate.Query;

import com.fudanmed.platform.core.domain.RCGroupTaskCriteria;

import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.pf.query.BaseStatCriteria;

public class RCGroupTaskStatCriteriaImpl extends
		BaseStatCriteria<RCGroupTaskStatCriteriaData> {

	@Override
	public Collection<RCGroupTaskStatCriteriaData> list() {
		String aggrCriteria = " select new com.fudanmed.platform.core.domain.impl.RCGroupTaskStatCriteriaData(this.team, count(*))"
				+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
		aggrCriteria += " group by this.team ";

		Query query = entities.createQuery(aggrCriteria);
		criteria.fillParameters(query);
		return (Collection<RCGroupTaskStatCriteriaData>) query.list();
	}

}
