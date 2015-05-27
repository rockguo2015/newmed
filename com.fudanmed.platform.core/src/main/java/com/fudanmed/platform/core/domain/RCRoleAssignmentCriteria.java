package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCRoleAssignment;
import com.fudanmed.platform.core.domain.impl.RCRoleAssignmentCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCRoleAssignmentCriteriaImpl.class)
public interface RCRoleAssignmentCriteria extends IPagedCriteria<RCRoleAssignment> {
  public abstract String getRoleType();
  
  public abstract RCRoleAssignmentCriteria setRoleType(final String roleType);
  
  public abstract RCEmployee getEmployee();
  
  public abstract RCRoleAssignmentCriteria setEmployee(final RCEmployee employee);
}
