package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage")
public class RCProductWarehouseStorageProxy extends RCProductStorageProxy {
  public RCProductWarehouseStorageProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCProductWarehouseStorage");
  }
}
