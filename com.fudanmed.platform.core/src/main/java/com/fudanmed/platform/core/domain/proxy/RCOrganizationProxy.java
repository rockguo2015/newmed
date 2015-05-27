package com.fudanmed.platform.core.domain.proxy;

import edu.fudan.langlab.domain.organization.proxy.PartyProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCOrganization")
public class RCOrganizationProxy extends PartyProxy {
  public RCOrganizationProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCOrganization");
  }
}
