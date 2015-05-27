package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCWorkItemStorage")
public class RCWorkItemStorageProxy extends RCProductStorageProxy {
  public RCWorkItemStorageProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCWorkItemStorage");
  }
}
