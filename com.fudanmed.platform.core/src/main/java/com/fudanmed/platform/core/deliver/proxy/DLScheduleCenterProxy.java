package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLTaskConsumerProxy;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLScheduleCenter")
public class DLScheduleCenterProxy extends GWTNamedEntity implements DLTaskConsumerProxy {
  public DLScheduleCenterProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLScheduleCenter");
  }
}
