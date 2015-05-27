package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCCompositeType")
public class RCCompositeTypeProxy extends RCTypeProxy {
  public RCCompositeTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCCompositeType");
  }
}
