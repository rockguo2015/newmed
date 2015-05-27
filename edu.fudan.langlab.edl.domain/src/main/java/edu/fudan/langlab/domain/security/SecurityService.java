package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.AppFunction;
import edu.fudan.langlab.domain.security.AppRole;
import edu.fudan.langlab.domain.security.Role;
import edu.fudan.langlab.domain.security.User;
import edu.fudan.langlab.domain.security.UserRoleAssignment;
import edu.fudan.mylang.pf.IBaseService;
import java.util.Collection;

public interface SecurityService extends IBaseService {
  public abstract Collection<UserRoleAssignment> getAllRoles4User(final String userid);
  
  public abstract Collection<Role> getAllRoles4User(final User user);
  
  public abstract Role createRole(final String roleId, final String roleName);
  
  public abstract Collection<User> getAllUsers4Role(final Role role);
  
  public abstract Role findRoleByRoleId(final String roleId);
  
  public abstract Collection<AppRole> getAllRoles();
  
  public abstract void assignRole2User(final Role role, final User user);
  
  public abstract void removeRoleFromUser(final Role role, final User user);
  
  public abstract void assignFunction2Role(final AppFunction function, final Role role);
  
  public abstract AppFunction createFunction(final String parentFunctionId, final String functionId, final String name);
  
  public abstract AppFunction createFunction(final AppFunction parentFunction, final String functionId, final String name);
  
  public abstract void removeFunctionFromRole(final AppFunction function, final Role role);
  
  public abstract void removeFunctionFromRoleCascade(final AppFunction function, final Role role);
  
  public abstract Collection<AppFunction> getAllFunctions4Role(final Role role);
  
  public abstract Collection<AppFunction> getAllFunctions4User(final User user);
}
