package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLPatientCheckDeliver")
public class DLPatientCheckDeliverProxy extends DLDeliverSubjectProxy {
  public DLPatientCheckDeliverProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLPatientCheckDeliver");
  }
}
