package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCRangeValue")
public class RCRangeValueProxy extends RCPrimaryValueProxy {
  public RCRangeValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCRangeValue");
  }
}
