package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLResourceEventProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLResourceLifecycleEvent")
public class DLResourceLifecycleEventProxy extends DLResourceEventProxy {
  public DLResourceLifecycleEventProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLResourceLifecycleEvent");
  }
}
