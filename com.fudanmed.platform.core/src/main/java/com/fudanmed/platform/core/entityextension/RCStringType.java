package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.RCStringValue;
import com.fudanmed.platform.core.entityextension.impl.RCStringTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCStringTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCStringTypeImpl.class)
public interface RCStringType extends RCPrimaryType {
  public abstract String getTypeName();
  
  public abstract RCStringValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract RCStringTypeProxy toProxy();
}
