package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCFaultLevelImpl;
import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCFaultLevelImpl.class)
public interface RCFaultLevel extends Code {
  public abstract RCFaultLevelProxy toProxy();
}
