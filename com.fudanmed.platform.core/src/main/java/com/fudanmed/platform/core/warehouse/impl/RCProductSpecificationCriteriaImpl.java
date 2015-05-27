package com.fudanmed.platform.core.warehouse.impl;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.RCProductSpecificationCriteria;
import com.google.common.base.Objects;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCProductSpecificationCriteriaImpl extends HQLBasedPagedQueryCriteria<RCProductSpecification> implements RCProductSpecificationCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public RCProductSpecificationCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  private RCProductCategory category;
  
  public RCProductCategory getCategory() {
    return this.category;
  }
  
  public RCProductSpecificationCriteria setCategory(final RCProductCategory category) {
    this.category = category;
    return this;			
    
  }
  
  private String categoryPath;
  
  public String getCategoryPath() {
    return this.categoryPath;
  }
  
  public RCProductSpecificationCriteria setCategoryPath(final String categoryPath) {
    this.categoryPath = categoryPath;
    return this;			
    
  }
  
  public void postInitialize() {
    boolean _notEquals = (!Objects.equal(this.category, null));
    if (_notEquals) {
      Long _id = this.category.getId();
      String _plus = ("%[" + _id);
      String _plus_1 = (_plus + "]%");
      this.categoryPath = _plus_1;
    }
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategoryPath()) ){
    	hql += " and (this.productType.categoryPath  LIKE :categoryPath)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((((this.sid  LIKE :info) or (this.name  LIKE :info)) or (this.simplePy  LIKE :info)) or (this.typeDesc  LIKE :info)) or (this.materialId  LIKE :info))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategoryPath())){
    	query.setParameter("categoryPath",getCategoryPath()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCProductSpecificationCriteriaImpl() {
    initOrderBys();
  }
}
