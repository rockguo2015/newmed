package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByReportSourceCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCRepairTaskStatByReportSourceCriteria extends BaseStatCriteria<RCRepairTaskStatByReportSourceCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCRepairTaskStatByReportSourceCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.domain.RCRepairTaskStatByReportSourceCriteriaData(this.faultReportSource,count(*))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.faultReportSource ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
