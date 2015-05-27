package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.RCFaultLevel;
import com.fudanmed.platform.core.common.RCStandardColor;
import com.fudanmed.platform.core.common.impl.RCFaultLevelColorAdaptorImpl;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import edu.fudan.mylang.pf.EntityImplementation;
import edu.fudan.mylang.pf.IModelObject;

@EntityImplementation(implementBy = RCFaultLevelColorAdaptorImpl.class)
public interface RCFaultLevelColorAdaptor extends IModelObject {
  public abstract RCStandardColor getColor();
  
  public abstract RCFaultLevelColorAdaptor setColor(final RCStandardColor color);
  
  public abstract RCFaultLevel getFaultLevel();
  
  public abstract RCFaultLevelColorAdaptor setFaultLevel(final RCFaultLevel faultLevel);
  
  public abstract RCFaultLevelColorAdaptorProxy toProxy();
}
