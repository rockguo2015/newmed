package com.fudanmed.platform.core.entityextension;

import com.fudanmed.platform.core.entityextension.RCValue;
import com.fudanmed.platform.core.entityextension.impl.RCPrimaryValueImpl;
import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCPrimaryValueImpl.class)
public interface RCPrimaryValue extends RCValue {
  public abstract String getEntityName();
  
  public abstract RCPrimaryValueProxy toProxy();
}
