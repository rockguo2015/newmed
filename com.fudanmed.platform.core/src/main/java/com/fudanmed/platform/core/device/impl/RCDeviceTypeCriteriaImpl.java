package com.fudanmed.platform.core.device.impl;

import com.fudanmed.platform.core.device.RCDeviceType;
import com.fudanmed.platform.core.device.RCDeviceTypeCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCDeviceTypeCriteriaImpl extends HQLBasedPagedQueryCriteria<RCDeviceType> implements RCDeviceTypeCriteria {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCDeviceTypeCriteria setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private String category;
  
  public String getCategory() {
    return this.category;
  }
  
  public RCDeviceTypeCriteria setCategory(final String category) {
    this.category = category;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.device.impl.RCDeviceTypeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName()) ){
    	hql += " and (this.name  LIKE :name)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategory()) ){
    	hql += " and (this.path  LIKE :category)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName())){
    	query.setParameter("name",getName()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getCategory())){
    	query.setParameter("category",getCategory()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCDeviceTypeCriteriaImpl() {
    initOrderBys();
  }
}
