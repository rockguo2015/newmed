package com.fudanmed.platform.core.deliver.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLPatientDeliverMethod")
public class DLPatientDeliverMethodProxy extends CodeProxy {
  public DLPatientDeliverMethodProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLPatientDeliverMethod");
  }
}
