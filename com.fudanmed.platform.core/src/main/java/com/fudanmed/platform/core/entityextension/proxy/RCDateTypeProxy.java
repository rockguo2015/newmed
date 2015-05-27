package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCDateType")
public class RCDateTypeProxy extends RCPrimaryTypeProxy {
  public RCDateTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCDateType");
  }
}
