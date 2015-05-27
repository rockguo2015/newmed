package com.fudanmed.platform.core.warehouse.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord")
public class RCWorkItemReturnStockRecordProxy extends RCWorkItemStockRecordProxy {
  public RCWorkItemReturnStockRecordProxy() {
    this.setClazzName("com.fudanmed.platform.core.warehouse.RCWorkItemReturnStockRecord");
  }
}
