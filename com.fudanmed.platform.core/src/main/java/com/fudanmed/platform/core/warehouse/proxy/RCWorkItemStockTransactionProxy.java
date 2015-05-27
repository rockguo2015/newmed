package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCWorkItemStockTransaction")
public class RCWorkItemStockTransactionProxy extends RCProductStoreTransactionProxy {
  public RCWorkItemStockTransactionProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCWorkItemStockTransaction");
  }
}
