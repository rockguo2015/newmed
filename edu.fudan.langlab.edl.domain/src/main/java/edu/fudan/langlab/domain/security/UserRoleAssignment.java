package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.impl.UserRoleAssignmentImpl;
import edu.fudan.langlab.domain.security.proxy.UserRoleAssignmentProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = UserRoleAssignmentImpl.class)
public interface UserRoleAssignment extends IModelObject {
  public abstract String getRoleId();
  
  public abstract UserRoleAssignment setRoleId(final String roleId);
  
  public abstract User getUser();
  
  public abstract UserRoleAssignment setUser(final User user);
  
  public abstract UserRoleAssignmentProxy toProxy();
}
