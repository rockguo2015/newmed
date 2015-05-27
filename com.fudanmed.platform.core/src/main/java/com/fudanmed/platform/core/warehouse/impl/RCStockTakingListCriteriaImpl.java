package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCStockTakingList;
import com.fudanmed.platform.core.warehouse.RCStockTakingListCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hibernate.Query;

public class RCStockTakingListCriteriaImpl extends HQLBasedPagedQueryCriteria<RCStockTakingList> implements RCStockTakingListCriteria {
  private RCWarehouse warehouse;
  
  public RCWarehouse getWarehouse() {
    return this.warehouse;
  }
  
  public RCStockTakingListCriteria setWarehouse(final RCWarehouse warehouse) {
    this.warehouse = warehouse;
    return this;			
    
  }
  
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public RCStockTakingListCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public RCStockTakingListCriteria setDateTo(final Date dateTo) {
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
  
  public RCStockTakingListCriteria setStores(final Collection<Long> stores) {
    this.stores = stores;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCStockTakingListImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getWarehouse()) ){
    	hql += " and (this.warehouse = :warehouse)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom()) ){
    	hql += " and (this.date >= :dateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo()) ){
    	hql += " and (this.date <= :dateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStores()) ){
    	hql += " and (this.warehouse.id  IN (:stores))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.date",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getWarehouse())){
    	query.setParameter("warehouse",getWarehouse()) ;
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
  
  public RCStockTakingListCriteriaImpl() {
    initOrderBys();
  }
}
