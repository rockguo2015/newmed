package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLDailyRoutineProtocal")
public class DLDailyRoutineProtocalProxy extends DLRoutineProtocalProxy {
  public DLDailyRoutineProtocalProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLDailyRoutineProtocal");
  }
}
