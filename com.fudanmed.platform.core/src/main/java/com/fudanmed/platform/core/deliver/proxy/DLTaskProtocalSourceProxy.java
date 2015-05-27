package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLTaskProtocalSource")
public class DLTaskProtocalSourceProxy extends DLTaskSourceProxy {
  public DLTaskProtocalSourceProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLTaskProtocalSource");
  }
}
