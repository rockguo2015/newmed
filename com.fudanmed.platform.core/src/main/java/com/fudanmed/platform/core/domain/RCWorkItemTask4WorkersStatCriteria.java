package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersStatCriteriaData;
import edu.fudan.mylang.pf.query.BaseStatCriteria;
import java.util.Collection;

public class RCWorkItemTask4WorkersStatCriteria extends BaseStatCriteria<RCWorkItemTask4WorkersStatCriteriaData> {
  public void initOrderBys() {
    
  }
  
  public Collection<RCWorkItemTask4WorkersStatCriteriaData> list() {
    criteria.postInitialize();
    String aggrCriteria = " select new com.fudanmed.platform.core.domain.RCWorkItemTask4WorkersStatCriteriaData(worker,count(*))"
    		+ criteria.getHQLFrom() + " " + criteria.getHQLBody();
    aggrCriteria += " group by worker ";
    aggrCriteria += buildOrderByString();
    org.hibernate.Query query = entities.createQuery(aggrCriteria);
    criteria.fillParameters(query);
    return doList(query);
    
  }
}
