package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLTaskSource4CustomerRequest")
public class DLTaskSource4CustomerRequestProxy extends DLTaskSourceProxy {
  public DLTaskSource4CustomerRequestProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLTaskSource4CustomerRequest");
  }
}
