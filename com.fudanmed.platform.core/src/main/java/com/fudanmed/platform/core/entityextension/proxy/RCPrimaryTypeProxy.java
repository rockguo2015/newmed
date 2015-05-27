package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCPrimaryType")
public class RCPrimaryTypeProxy extends RCTypeProxy {
  public RCPrimaryTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCPrimaryType");
  }
}
