package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummary;
import com.fudanmed.platform.core.warehouse.RCProductWarehouseStorageSummaryCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.hibernate.Query;

public class RCProductWarehouseStorageSummaryCriteriaImpl extends HQLBasedPagedQueryCriteria<RCProductWarehouseStorageSummary> implements RCProductWarehouseStorageSummaryCriteria {
  private RCWarehouse store;
  
  public RCWarehouse getStore() {
    return this.store;
  }
  
  public RCProductWarehouseStorageSummaryCriteria setStore(final RCWarehouse store) {
    this.store = store;
    return this;			
    
  }
  
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCProductWarehouseStorageSummaryCriteria setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  private RCProductType productType;
  
  public RCProductType getProductType() {
    return this.productType;
  }
  
  public RCProductWarehouseStorageSummaryCriteria setProductType(final RCProductType productType) {
    this.productType = productType;
    return this;			
    
  }
  
  private String productInfo;
  
  public String getProductInfo() {
    return this.productInfo;
  }
  
  public RCProductWarehouseStorageSummaryCriteria setProductInfo(final String productInfo) {
    this.productInfo = productInfo;
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
  
  public RCProductWarehouseStorageSummaryCriteria setStores(final Collection<Long> stores) {
    this.stores = stores;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCProductWarehouseStorageSummaryImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStores()) ){
    	hql += " and (this.store.id  IN (:stores))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStore()) ){
    	hql += " and (this.store = :store)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductType()) ){
    	hql += " and (this.productSpec.productType = :productType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductSpec()) ){
    	hql += " and (this.productSpec = :productSpec)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo()) ){
    	hql += " and (((this.productSpec.name  LIKE :productInfo) or (this.productSpec.simplePy  LIKE :productInfo)) or (this.productSpec.sid  LIKE :productInfo))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStore())){
    	query.setParameter("store",getStore()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductSpec())){
    	query.setParameter("productSpec",getProductSpec()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductType())){
    	query.setParameter("productType",getProductType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductInfo())){
    	query.setParameter("productInfo",getProductInfo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStores())){
    	query.setParameterList("stores",getStores()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCProductWarehouseStorageSummaryCriteriaImpl() {
    initOrderBys();
  }
}
