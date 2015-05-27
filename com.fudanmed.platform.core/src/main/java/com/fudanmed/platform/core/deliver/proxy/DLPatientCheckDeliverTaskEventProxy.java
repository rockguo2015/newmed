package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLTaskEventProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent")
public class DLPatientCheckDeliverTaskEventProxy extends DLTaskEventProxy {
  public DLPatientCheckDeliverTaskEventProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLPatientCheckDeliverTaskEvent");
  }
}
