package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.impl.UserImpl;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = UserImpl.class)
public interface User extends IModelObject, INamedModelObject {
  public abstract String getUserid();
  
  public abstract User setUserid(final String userid);
  
  public abstract String getPasswd();
  
  public abstract User setPasswd(final String passwd);
  
  public abstract String getEntityName();
  
  public abstract UserProxy toProxy();
}
