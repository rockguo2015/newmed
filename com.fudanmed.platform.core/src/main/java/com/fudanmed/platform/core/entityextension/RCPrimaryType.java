package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntityType;
import com.fudanmed.platform.core.entityextension.RCPrimaryValue;
import com.fudanmed.platform.core.entityextension.RCType;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCPrimaryTypeImpl.class)
public interface RCPrimaryType extends RCType {
  public abstract String getTypeName();
  
  public abstract RCPrimaryValue createInstance(final RCExtensiableEntity owner);
  
  public abstract RCType cloneType(final RCExtensiableEntityType extensiableEntity);
  
  public abstract RCPrimaryTypeProxy toProxy();
}
