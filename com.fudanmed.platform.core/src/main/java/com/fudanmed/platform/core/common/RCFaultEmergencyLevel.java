package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCFaultEmergencyLevelImpl;
import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCFaultEmergencyLevelImpl.class)
public interface RCFaultEmergencyLevel extends Code {
  public abstract RCFaultEmergencyLevelProxy toProxy();
}
