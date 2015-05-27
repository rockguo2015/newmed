package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeByNameCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCEmployeeByNameCriteriaImpl extends HQLBasedPagedQueryCriteria<RCEmployee> implements RCEmployeeByNameCriteria {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public RCEmployeeByNameCriteria setName(final String name) {
    this.name = name;
    return this;			
    
  }
  
  private Boolean isLeaveJob;
  
  public Boolean getIsLeaveJob() {
    return this.isLeaveJob;
  }
  
  public RCEmployeeByNameCriteria setIsLeaveJob(final Boolean isLeaveJob) {
    this.isLeaveJob = isLeaveJob;
    return this;			
    
  }
  
  public void initialize() {
    this.isLeaveJob = Boolean.valueOf(false);
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName()) ){
    	hql += " and ((this.name  LIKE :name) or (this.simplePy  LIKE :name))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIsLeaveJob()) ){
    	hql += " and (this.isLeaveJob = :isLeaveJob)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getName())){
    	query.setParameter("name",getName()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIsLeaveJob())){
    	query.setParameter("isLeaveJob",getIsLeaveJob()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCEmployeeByNameCriteriaImpl() {
    initOrderBys();
  }
}
