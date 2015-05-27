package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCInStoreTransaction")
public class RCInStoreTransactionProxy extends RCProductStoreTransactionProxy {
  public RCInStoreTransactionProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCInStoreTransaction");
  }
}
