package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLSingleDayProtocal")
public class DLSingleDayProtocalProxy extends DLRoutineProtocalProxy {
  public DLSingleDayProtocalProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLSingleDayProtocal");
  }
}
