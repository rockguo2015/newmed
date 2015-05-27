package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeUserImpl;
import com.fudanmed.platform.core.domain.proxy.RCEmployeeUserProxy;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCEmployeeUserImpl.class)
public interface RCEmployeeUser extends User {
  public abstract RCEmployee getEmployee();
  
  public abstract RCEmployeeUser setEmployee(final RCEmployee employee);
  
  public abstract String getEntityName();
  
  public abstract RCEmployeeUserProxy toProxy();
}
