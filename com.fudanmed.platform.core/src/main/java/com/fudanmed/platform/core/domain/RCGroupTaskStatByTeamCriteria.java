package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCGroupTaskStatByTeamCriteria extends BaseStatCriteria<RCGroupTaskStatByTeamCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCGroupTaskStatByTeamCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.domain.RCGroupTaskStatByTeamCriteriaData(count(*),this.team)"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.team ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
