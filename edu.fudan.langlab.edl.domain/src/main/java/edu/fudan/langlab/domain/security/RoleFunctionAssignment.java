package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.impl.RoleFunctionAssignmentImpl;
import edu.fudan.langlab.domain.security.proxy.RoleFunctionAssignmentProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RoleFunctionAssignmentImpl.class)
public interface RoleFunctionAssignment extends IModelObject {
  public abstract String getRoleId();
  
  public abstract RoleFunctionAssignment setRoleId(final String roleId);
  
  public abstract AppFunction getFunction();
  
  public abstract RoleFunctionAssignment setFunction(final AppFunction function);
  
  public abstract RoleFunctionAssignmentProxy toProxy();
}
