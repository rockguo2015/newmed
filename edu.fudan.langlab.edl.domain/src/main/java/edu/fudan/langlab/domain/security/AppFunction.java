package edu.fudan.langlab.domain.security;

import edu.fudan.langlab.domain.security.impl.AppFunctionImpl;
import edu.fudan.langlab.domain.security.proxy.AppFunctionProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = AppFunctionImpl.class)
public interface AppFunction extends IModelObject, INamedModelObject {
  public abstract String getParentFunctionId();
  
  public abstract AppFunction setParentFunctionId(final String parentFunctionId);
  
  public abstract String getFunctionId();
  
  public abstract AppFunction setFunctionId(final String functionId);
  
  public abstract String getName();
  
  public abstract AppFunction setName(final String name);
  
  public abstract AppFunction getParent();
  
  public abstract Collection<AppFunction> getFunctionsFromPath();
  
  public abstract Collection<AppFunction> getSubFunctions();
  
  public abstract Collection<AppFunction> collectSubFunctions(final Collection<AppFunction> result);
  
  public abstract String getEntityName();
  
  public abstract AppFunctionProxy toProxy();
}
