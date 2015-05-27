package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStoreTransactionProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCTransferTransaction")
public class RCTransferTransactionProxy extends RCProductStoreTransactionProxy {
  public RCTransferTransactionProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCTransferTransaction");
  }
}
