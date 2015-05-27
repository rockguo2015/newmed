package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLTaskProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask")
public class DLCenterlizedDeliverTaskProxy extends DLTaskProxy {
  public DLCenterlizedDeliverTaskProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLCenterlizedDeliverTask");
  }
}
