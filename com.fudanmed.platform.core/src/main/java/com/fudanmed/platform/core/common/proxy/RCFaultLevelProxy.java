package com.fudanmed.platform.core.common.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.common.RCFaultLevel")
public class RCFaultLevelProxy extends CodeProxy {
  public RCFaultLevelProxy() {
    this.setClazzName("com.fudanmed.platform.core.common.RCFaultLevel");
  }
}
