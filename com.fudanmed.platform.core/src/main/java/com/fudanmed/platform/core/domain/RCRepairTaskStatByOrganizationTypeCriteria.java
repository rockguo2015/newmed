package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCRepairTaskStatByOrganizationTypeCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCRepairTaskStatByOrganizationTypeCriteria extends BaseStatCriteria<RCRepairTaskStatByOrganizationTypeCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCRepairTaskStatByOrganizationTypeCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.domain.RCRepairTaskStatByOrganizationTypeCriteriaData(this.reportOrg,count(*))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by this.reportOrg ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
