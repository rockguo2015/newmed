package edu.fudan.langlab.domain.code;

import edu.fudan.langlab.domain.code.impl.CodeImpl;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;
import edu.fudan.mylang.pf.INamedModelObject;

@EntityImplementation(implementBy = CodeImpl.class)
public interface Code extends IModelObject, INamedModelObject {
  public abstract String getCodeid();
  
  public abstract Code setCodeid(final String codeid);
  
  public abstract String getName();
  
  public abstract Code setName(final String name);
  
  public abstract String getEntityName();
  
  public abstract CodeProxy toProxy();
}
