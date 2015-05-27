package com.fudanmed.platform.core.domain.proxy;

import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCRepairReportUser")
public class RCRepairReportUserProxy extends UserProxy {
  public RCRepairReportUserProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCRepairReportUser");
  }
}
