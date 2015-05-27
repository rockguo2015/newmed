package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCStockTakingRecord;
import com.fudanmed.platform.core.warehouse.RCStockTakingRecordCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCStockTakingRecordCriteriaImpl extends HQLBasedPagedQueryCriteria<RCStockTakingRecord> implements RCStockTakingRecordCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCStockTakingRecordCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public RCStockTakingRecordCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public RCStockTakingRecordCriteria setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCStockTakingRecordImpl this ";
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
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom())){
    	query.setParameter("dateFrom",getDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo())){
    	query.setParameter("dateTo",getDateTo()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCStockTakingRecordCriteriaImpl() {
    initOrderBys();
  }
}
