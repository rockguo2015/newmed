package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.RCOrganizationCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCOrganizationCriteriaImpl extends HQLBasedPagedQueryCriteria<RCOrganization> implements RCOrganizationCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public RCOrganizationCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCOrganizationImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((this.code  LIKE :info) or (this.name  LIKE :info)) or (this.simplePy  LIKE :info))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCOrganizationCriteriaImpl() {
    initOrderBys();
  }
}
