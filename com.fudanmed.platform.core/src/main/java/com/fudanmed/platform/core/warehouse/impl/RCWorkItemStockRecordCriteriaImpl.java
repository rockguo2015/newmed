package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecord;
import com.fudanmed.platform.core.warehouse.RCWorkItemStockRecordCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCWorkItemStockRecordCriteriaImpl extends HQLBasedPagedQueryCriteria<RCWorkItemStockRecord> implements RCWorkItemStockRecordCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCWorkItemStockRecordCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCWorkItemStockRecordImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.sid  LIKE :sid)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.date",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid())){
    	query.setParameter("sid",getSid()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCWorkItemStockRecordCriteriaImpl() {
    initOrderBys();
  }
}
