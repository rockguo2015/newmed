package com.fudanmed.platform.core.domain.proxy;

import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCEmployeeUser")
public class RCEmployeeUserProxy extends UserProxy {
  public RCEmployeeUserProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCEmployeeUser");
  }
}
