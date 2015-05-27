package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord")
public class RCWorkItemOutStockRecordProxy extends RCWorkItemStockRecordProxy {
  public RCWorkItemOutStockRecordProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCWorkItemOutStockRecord");
  }
}
