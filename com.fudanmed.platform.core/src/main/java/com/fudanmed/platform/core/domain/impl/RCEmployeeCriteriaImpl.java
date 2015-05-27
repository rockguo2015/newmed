package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCEmployeeCriteria;
import com.fudanmed.platform.core.domain.RCOrganization;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCEmployeeCriteriaImpl extends HQLBasedPagedQueryCriteria<RCEmployee> implements RCEmployeeCriteria {
  private String info;
  
  public String getInfo() {
    return this.info;
  }
  
  public RCEmployeeCriteria setInfo(final String info) {
    this.info = info;
    return this;			
    
  }
  
  private Boolean includeLeaveEmployees;
  
  public Boolean getIncludeLeaveEmployees() {
    return this.includeLeaveEmployees;
  }
  
  public RCEmployeeCriteria setIncludeLeaveEmployees(final Boolean includeLeaveEmployees) {
    this.includeLeaveEmployees = includeLeaveEmployees;
    return this;			
    
  }
  
  private String orgPath;
  
  public String getOrgPath() {
    return this.orgPath;
  }
  
  public RCEmployeeCriteria setOrgPath(final String orgPath) {
    this.orgPath = orgPath;
    return this;			
    
  }
  
  private RCOrganization organization;
  
  public RCOrganization getOrganization() {
    return this.organization;
  }
  
  public RCEmployeeCriteria setOrganization(final RCOrganization organization) {
    this.organization = organization;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCEmployeeImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) && !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo()) ){
    	hql += " and (((((this.eid  LIKE :info) or (this.name  LIKE :info)) or (this.phone  LIKE :info)) or (this.email  LIKE :info)) or (this.address  LIKE :info))" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOrganization()) ){
    	hql += " and (this.organization = :organization)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOrgPath()) ){
    	hql += " and (this.orgPath  LIKE :orgPath)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeLeaveEmployees()) ){
    	hql += " and ((this.isLeaveJob = false) or (:includeLeaveEmployees = true))" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getInfo())){
    	query.setParameter("info",getInfo()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getIncludeLeaveEmployees())){
    	query.setParameter("includeLeaveEmployees",getIncludeLeaveEmployees()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOrgPath())){
    	query.setParameter("orgPath",getOrgPath()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getOrganization())){
    	query.setParameter("organization",getOrganization()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCEmployeeCriteriaImpl() {
    initOrderBys();
  }
}
