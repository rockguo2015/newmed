package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCNumberType")
public class RCNumberTypeProxy extends RCPrimaryTypeProxy {
  public RCNumberTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCNumberType");
  }
}
