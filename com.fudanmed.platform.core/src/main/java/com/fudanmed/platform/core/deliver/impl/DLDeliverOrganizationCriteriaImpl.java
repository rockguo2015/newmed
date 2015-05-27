package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLDeliverOrganization;
import com.fudanmed.platform.core.deliver.DLDeliverOrganizationCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class DLDeliverOrganizationCriteriaImpl extends HQLBasedPagedQueryCriteria<DLDeliverOrganization> implements DLDeliverOrganizationCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public DLDeliverOrganizationCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLDeliverOrganizationImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and ((this.code  LIKE :info) or (this.name  LIKE :info))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.name",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public DLDeliverOrganizationCriteriaImpl() {
    initOrderBys();
  }
}
