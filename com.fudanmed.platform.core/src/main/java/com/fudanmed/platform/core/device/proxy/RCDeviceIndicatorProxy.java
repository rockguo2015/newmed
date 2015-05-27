package com.fudanmed.platform.core.device.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.device.RCDeviceIndicator")
public class RCDeviceIndicatorProxy extends CodeProxy {
  public RCDeviceIndicatorProxy() {
    this.setClazzName("com.fudanmed.platform.core.device.RCDeviceIndicator");
  }
}
