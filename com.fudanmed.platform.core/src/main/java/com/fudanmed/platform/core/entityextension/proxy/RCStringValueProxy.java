package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCStringValue")
public class RCStringValueProxy extends RCPrimaryValueProxy {
  public RCStringValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCStringValue");
  }
}
