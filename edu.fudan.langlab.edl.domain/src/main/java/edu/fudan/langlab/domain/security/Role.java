package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.impl.RoleImpl;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = RoleImpl.class)
public interface Role extends IModelObject, INamedModelObject {
  public abstract String getRoleId();
  
  public abstract Role setRoleId(final String roleId);
  
  public abstract Boolean getIsBuildin();
  
  public abstract Role setIsBuildin(final Boolean isBuildin);
  
  public abstract String getName();
  
  public abstract Role setName(final String name);
  
  public abstract String getEntityName();
  
  public abstract RoleProxy toProxy();
}
