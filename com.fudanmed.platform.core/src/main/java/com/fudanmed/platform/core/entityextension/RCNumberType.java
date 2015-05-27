package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCExtensiableEntity;
import com.fudanmed.platform.core.entityextension.RCNumberValue;
import com.fudanmed.platform.core.entityextension.RCPrimaryType;
import com.fudanmed.platform.core.entityextension.impl.RCNumberTypeImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCNumberTypeProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCNumberTypeImpl.class)
public interface RCNumberType extends RCPrimaryType {
  public abstract String getTypeName();
  
  public abstract RCNumberValue createInstance(final RCExtensiableEntity rootOwner);
  
  public abstract RCNumberTypeProxy toProxy();
}
