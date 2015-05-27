package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCOutStockRecord;
import com.fudanmed.platform.core.warehouse.RCOutStockRecordCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hibernate.Query;

public class RCOutStockRecordCriteriaImpl extends HQLBasedPagedQueryCriteria<RCOutStockRecord> implements RCOutStockRecordCriteria {
  private String sid;
  
  public String getSid() {
    return this.sid;
  }
  
  public RCOutStockRecordCriteria setSid(final String sid) {
    this.sid = sid;
    return this;			
    
  }
  
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public RCOutStockRecordCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public RCOutStockRecordCriteria setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
    return this;			
    
  }
  
  private Collection<Long> stores = new Function0<Collection<Long>>() {
    public Collection<Long> apply() {
      ArrayList<Long> _newArrayList = CollectionLiterals.<Long>newArrayList();
      return _newArrayList;
    }
  }.apply();
  
  public Collection<Long> getStores() {
    return this.stores;
  }
  
  public RCOutStockRecordCriteria setStores(final Collection<Long> stores) {
    this.stores = stores;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCOutStockRecordImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getSid()) ){
    	hql += " and (this.sid  LIKE :sid)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom()) ){
    	hql += " and (this.date >= :dateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo()) ){
    	hql += " and (this.date <= :dateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStores()) ){
    	hql += " and (this.sourceStore.id  IN (:stores))" ;
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
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStores())){
    	query.setParameterList("stores",getStores()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCOutStockRecordCriteriaImpl() {
    initOrderBys();
  }
}
