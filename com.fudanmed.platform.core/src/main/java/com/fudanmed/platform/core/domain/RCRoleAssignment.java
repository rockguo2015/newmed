package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCRoleAssignmentImpl;
import com.fudanmed.platform.core.domain.proxy.RCRoleAssignmentProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Date;

@EntityImplementation(implementBy = RCRoleAssignmentImpl.class)
public interface RCRoleAssignment extends IModelObject {
  public abstract String getRoleType();
  
  public abstract RCRoleAssignment setRoleType(final String roleType);
  
  public abstract RCEmployee getEmployee();
  
  public abstract RCRoleAssignment setEmployee(final RCEmployee employee);
  
  public abstract Date getStartDate();
  
  public abstract RCRoleAssignment setStartDate(final Date startDate);
  
  public abstract RCRoleAssignmentProxy toProxy();
}
