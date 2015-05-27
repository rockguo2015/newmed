package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCDateValue")
public class RCDateValueProxy extends RCPrimaryValueProxy {
  public RCDateValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCDateValue");
  }
}
