package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRoleAssignment;
import com.fudanmed.platform.core.domain.RCRoleAssignmentCriteria;
import edu.fudan.mylang.pf.query.HQLBasedPagedQueryCriteria;
import org.hibernate.Query;

public class RCRoleAssignmentCriteriaImpl extends HQLBasedPagedQueryCriteria<RCRoleAssignment> implements RCRoleAssignmentCriteria {
  private String roleType;
  
  public String getRoleType() {
    return this.roleType;
  }
  
  public RCRoleAssignmentCriteria setRoleType(final String roleType) {
    this.roleType = roleType;
    return this;			
    
  }
  
  private RCEmployee employee;
  
  public RCEmployee getEmployee() {
    return this.employee;
  }
  
  public RCRoleAssignmentCriteria setEmployee(final RCEmployee employee) {
    this.employee = employee;
    return this;			
    
  }
  
  protected String buildHQLFrom() {
    return " from com.fudanmed.platform.core.domain.impl.RCRoleAssignmentImpl this ";
  }
  
  protected String buildHQLBody() {
    String hql = "where 1 = 1 ";
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getRoleType()) ){
    	hql += " and (this.roleType = :roleType)" ;
    }
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getEmployee()) ){
    	hql += " and (this.employee = :employee)" ;
    }
    return hql;
    
  }
  
  public void initOrderBys() {
    
  }
  
  protected void fillParameter(final Query query) {
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getRoleType())){
    	query.setParameter("roleType",getRoleType()) ;
    }			
    if( !edu.fudan.mylang.pf.query.QueryUtil.isNull(getEmployee())){
    	query.setParameter("employee",getEmployee()) ;
    }			
    
  }
  
  protected Boolean isDistinct() {
    return false;
  }
  
  public RCRoleAssignmentCriteriaImpl() {
    initOrderBys();
  }
}
