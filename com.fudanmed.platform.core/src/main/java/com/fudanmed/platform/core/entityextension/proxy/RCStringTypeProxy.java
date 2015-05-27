package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCStringType")
public class RCStringTypeProxy extends RCPrimaryTypeProxy {
  public RCStringTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCStringType");
  }
}
