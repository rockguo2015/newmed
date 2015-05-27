package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLResourceEventProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent")
public class DLResourceExtBorrowEventProxy extends DLResourceEventProxy {
  public DLResourceExtBorrowEventProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLResourceExtBorrowEvent");
  }
}
