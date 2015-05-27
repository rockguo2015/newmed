package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshot;
import com.fudanmed.platform.core.warehouse.RCProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.warehouse.RCWarehouse;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import java.util.Date;
import org.hibernate.Query;

public class RCProductSummarySnapshotCriteriaImpl extends HQLBasedPagedQueryCriteria<RCProductSummarySnapshot> implements RCProductSummarySnapshotCriteria {
  private Date dateFrom;
  
  public Date getDateFrom() {
    return this.dateFrom;
  }
  
  public RCProductSummarySnapshotCriteria setDateFrom(final Date dateFrom) {
    this.dateFrom = dateFrom;
    return this;			
    
  }
  
  private Date dateTo;
  
  public Date getDateTo() {
    return this.dateTo;
  }
  
  public RCProductSummarySnapshotCriteria setDateTo(final Date dateTo) {
    this.dateTo = dateTo;
    return this;			
    
  }
  
  private RCWarehouse store;
  
  public RCWarehouse getStore() {
    return this.store;
  }
  
  public RCProductSummarySnapshotCriteria setStore(final RCWarehouse store) {
    this.store = store;
    return this;			
    
  }
  
  private RCProductSpecification productSpec;
  
  public RCProductSpecification getProductSpec() {
    return this.productSpec;
  }
  
  public RCProductSummarySnapshotCriteria setProductSpec(final RCProductSpecification productSpec) {
    this.productSpec = productSpec;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCProductSummarySnapshotImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom()) ){
    	hql += " and (this.date >= :dateFrom)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo()) ){
    	hql += " and (this.date <= :dateTo)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getProductSpec()) ){
    	hql += " and (this.storageSummary.productSpec = :productSpec)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getStore()) ){
    	hql += " and (this.storageSummary.store = :store)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateFrom())){
    	query.setParameter("dateFrom",getDateFrom()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getDateTo())){
    	query.setParameter("dateTo",getDateTo()) ;
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
  
  public RCProductSummarySnapshotCriteriaImpl() {
    initOrderBys();
  }
}
