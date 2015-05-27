package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLRoutineProtocalProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLWeeklyRoutineProtocal")
public class DLWeeklyRoutineProtocalProxy extends DLRoutineProtocalProxy {
  public DLWeeklyRoutineProtocalProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLWeeklyRoutineProtocal");
  }
}
