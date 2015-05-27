package com.fudanmed.platform.core.domain.proxy;

import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCEnterprise")
public class RCEnterpriseProxy extends PartyProxy {
  public RCEnterpriseProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCEnterprise");
  }
}
