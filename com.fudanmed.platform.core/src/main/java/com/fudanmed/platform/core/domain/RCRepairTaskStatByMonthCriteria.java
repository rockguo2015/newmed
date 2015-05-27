package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByMonthCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCRepairTaskStatByMonthCriteria extends BaseStatCriteria<RCRepairTaskStatByMonthCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCRepairTaskStatByMonthCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.domain.RCRepairTaskStatByMonthCriteriaData(this.month,count(*))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.month ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
