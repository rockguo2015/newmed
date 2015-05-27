package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCNumberValue")
public class RCNumberValueProxy extends RCPrimaryValueProxy {
  public RCNumberValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCNumberValue");
  }
}
