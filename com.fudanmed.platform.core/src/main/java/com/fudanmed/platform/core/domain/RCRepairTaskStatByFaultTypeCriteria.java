package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByFaultTypeCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCRepairTaskStatByFaultTypeCriteria extends BaseStatCriteria<RCRepairTaskStatByFaultTypeCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCRepairTaskStatByFaultTypeCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.domain.RCRepairTaskStatByFaultTypeCriteriaData(this.faultType,count(*))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.faultType ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
