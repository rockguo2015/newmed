package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCStockTakingTransaction")
public class RCStockTakingTransactionProxy extends RCProductStoreTransactionProxy {
  public RCStockTakingTransactionProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCStockTakingTransaction");
  }
}
