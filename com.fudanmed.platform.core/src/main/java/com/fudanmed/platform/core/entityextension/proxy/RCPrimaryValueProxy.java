package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCPrimaryValue")
public class RCPrimaryValueProxy extends RCValueProxy {
  public RCPrimaryValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCPrimaryValue");
  }
}
