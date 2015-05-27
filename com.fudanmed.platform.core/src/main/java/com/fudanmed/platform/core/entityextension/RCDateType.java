package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCDateValue;
import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.impl.RCDateTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCDateTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDateTypeImpl.class)
public interface RCDateType extends RCPrimaryType {
  public abstract String getTypeName();
  
  public abstract RCDateValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract RCDateTypeProxy toProxy();
}
