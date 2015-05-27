package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductStorage;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransaction;
import com.fudanmed.platform.core.warehouse.RCProductStoreTransactionCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCProductStoreTransactionCriteriaImpl extends HQLBasedPagedQueryCriteria<RCProductStoreTransaction> implements RCProductStoreTransactionCriteria {
  private RCProductStorage productStorage;
  
  public RCProductStorage getProductStorage() {
    return this.productStorage;
  }
  
  public RCProductStoreTransactionCriteria setProductStorage(final RCProductStorage productStorage) {
    this.productStorage = productStorage;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCProductStoreTransactionImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductStorage()) ){
    	hql += " and (this.productStorage = :productStorage)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    addOrder("this.date",edu.fudan.mylang.pf.query.OrderItem.DESC);
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductStorage())){
    	query.setParameter("productStorage",getProductStorage()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCProductStoreTransactionCriteriaImpl() {
    initOrderBys();
  }
}
