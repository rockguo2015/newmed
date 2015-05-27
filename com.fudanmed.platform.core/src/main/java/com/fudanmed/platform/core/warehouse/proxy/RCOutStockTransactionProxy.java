package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCOutStockTransaction")
public class RCOutStockTransactionProxy extends RCProductStoreTransactionProxy {
  public RCOutStockTransactionProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCOutStockTransaction");
  }
}
