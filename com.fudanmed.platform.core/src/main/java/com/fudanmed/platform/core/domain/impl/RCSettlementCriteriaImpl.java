package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCSettlement;
import com.fudanmed.platform.core.domain.RCSettlementCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCSettlementCriteriaImpl extends HQLBasedPagedQueryCriteria<RCSettlement> implements RCSettlementCriteria {
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCSettlementImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.date",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCSettlementCriteriaImpl() {
    initOrderBys();
  }
}
