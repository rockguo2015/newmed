package com.fudanmed.platform.core.domain.proxy;

import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCEmployee")
public class RCEmployeeProxy extends PartyProxy {
  public RCEmployeeProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCEmployee");
  }
}
