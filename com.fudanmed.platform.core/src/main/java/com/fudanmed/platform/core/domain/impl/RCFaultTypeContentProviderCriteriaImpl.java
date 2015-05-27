package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.RCFaultTypeContentProviderCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCFaultTypeContentProviderCriteriaImpl extends HQLBasedPagedQueryCriteria<RCFaultType> implements RCFaultTypeContentProviderCriteria {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCFaultTypeContentProviderCriteria setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCFaultTypeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName()) ){
    	hql += " and ((this.name  LIKE :name) or (this.simplePy  LIKE :name))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName())){
    	query.setParameter("name",getName()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCFaultTypeContentProviderCriteriaImpl() {
    initOrderBys();
  }
}
