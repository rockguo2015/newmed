package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.impl.RCMaintenamceTypeImpl;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IHasSimplePy;
import edu.fudan.mylang.pf.IModelObject;
import java.util.Collection;

@EntityImplementation(implementBy = RCMaintenamceTypeImpl.class)
public interface RCMaintenamceType extends IModelObject, IHasSimplePy {
  public abstract String getCode();
  
  public abstract RCMaintenamceType setCode(final String code);
  
  public abstract String getName();
  
  public abstract RCMaintenamceType setName(final String name);
  
  public abstract String getSimplePy();
  
  public abstract RCMaintenamceType setSimplePy(final String simplePy);
  
  public abstract RCMaintenamceType getParent();
  
  public abstract RCMaintenamceType setParent(final RCMaintenamceType parent);
  
  public abstract Collection<RCMaintenamceType> getSubTypes();
  
  public abstract RCMaintenamceType createAndAddtoSubTypes();
  
  public abstract RCMaintenamceType removeFromSubTypes(final RCMaintenamceType rCMaintenamceType);
  
  public abstract RCMaintenamceType removeAllSubTypes();
  
  public abstract Collection<RCFaultType> getFaultTypes();
  
  public abstract RCFaultType createAndAddtoFaultTypes();
  
  public abstract RCMaintenamceType removeFromFaultTypes(final RCFaultType rCFaultType);
  
  public abstract RCMaintenamceType removeAllFaultTypes();
  
  public abstract String getEntityName();
  
  public abstract String getNameField();
  
  public abstract Collection<RCFaultType> getAllSubFaultTypes();
  
  public abstract RCMaintenamceTypeProxy toProxy();
}
