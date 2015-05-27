package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCProductWarehouseStorageCriteriaImpl extends HQLBasedPagedQueryCriteria<RCProductWarehouseStorage> implements RCProductWarehouseStorageCriteria {
  private String productInfo;
  
  public String getProductInfo() {
    return this.productInfo;
  }
  
  public RCProductWarehouseStorageCriteria setProductInfo(final String productInfo) {
    this.productInfo = productInfo;
    return this;			
    
  }
  
  private RCWarehouse store;
  
  public RCWarehouse getStore() {
    return this.store;
  }
  
  public RCProductWarehouseStorageCriteria setStore(final RCWarehouse store) {
    this.store = store;
    return this;			
    
  }
  
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCProductWarehouseStorageCriteria setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo()) ){
    	hql += " and (((this.productEntry.productSpec.name  LIKE :productInfo) or (this.productEntry.productSpec.simplePy  LIKE :productInfo)) or (this.productEntry.productSpec.sid  LIKE :productInfo))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStore()) ){
    	hql += " and (this.store = :store)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductSpec()) ){
    	hql += " and (this.productEntry.productSpec = :productSpec)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo())){
    	query.setParameter("productInfo",getProductInfo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStore())){
    	query.setParameter("store",getStore()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductSpec())){
    	query.setParameter("productSpec",getProductSpec()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCProductWarehouseStorageCriteriaImpl() {
    initOrderBys();
  }
}
