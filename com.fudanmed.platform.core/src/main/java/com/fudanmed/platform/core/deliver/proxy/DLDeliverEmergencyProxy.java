package com.fudanmed.platform.core.deliver.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLDeliverEmergency")
public class DLDeliverEmergencyProxy extends CodeProxy {
  public DLDeliverEmergencyProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLDeliverEmergency");
  }
}
