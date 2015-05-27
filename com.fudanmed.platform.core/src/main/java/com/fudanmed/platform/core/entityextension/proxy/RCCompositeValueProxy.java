package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCCompositeValue")
public class RCCompositeValueProxy extends RCValueProxy {
  public RCCompositeValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCCompositeValue");
  }
}
