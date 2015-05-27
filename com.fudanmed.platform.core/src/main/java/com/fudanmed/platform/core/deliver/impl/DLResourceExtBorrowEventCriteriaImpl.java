package com.fudanmed.platform.core.deliver.impl;

import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent;
import com.fudanmed.platform.core.deliver.DLResourceExtBorrowEventCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class DLResourceExtBorrowEventCriteriaImpl extends HQLBasedPagedQueryCriteria<DLResourceExtBorrowEvent> implements DLResourceExtBorrowEventCriteria {
  private Boolean returned;
  
  public Boolean getReturned() {
    return this.returned;
  }
  
  public DLResourceExtBorrowEventCriteria setReturned(final Boolean returned) {
    this.returned = returned;
    return this;			
    
  }
  
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public DLResourceExtBorrowEventCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public DLResourceExtBorrowEventCriteria setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.deliver.impl.DLResourceExtBorrowEventImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReturned()) ){
    	hql += " and (this.returned = :returned)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom()) ){
    	hql += " and (this.date >= :dateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo()) ){
    	hql += " and (this.date <= :dateTo)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getReturned())){
    	query.setParameter("returned",getReturned()) ;
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
  
  public DLResourceExtBorrowEventCriteriaImpl() {
    initOrderBys();
  }
}
