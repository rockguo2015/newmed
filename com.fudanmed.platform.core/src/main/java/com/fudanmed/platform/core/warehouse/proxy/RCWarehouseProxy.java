package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCRCProductStorageContainerProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCWarehouse")
public class RCWarehouseProxy extends RCRCProductStorageContainerProxy {
  public RCWarehouseProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCWarehouse");
  }
}
