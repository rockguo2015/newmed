package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLMonthlyRoutineProtocal")
public class DLMonthlyRoutineProtocalProxy extends DLRoutineProtocalProxy {
  public DLMonthlyRoutineProtocalProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLMonthlyRoutineProtocal");
  }
}
