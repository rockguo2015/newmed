package com.fudanmed.platform.core.common.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.common.RCFaultReportSource")
public class RCFaultReportSourceProxy extends CodeProxy {
  public RCFaultReportSourceProxy() {
    this.setClazzName("com.fudanmed.platform.core.common.RCFaultReportSource");
  }
}
