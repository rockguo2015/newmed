package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryValueProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue")
public class RCNumberWithUnitValueProxy extends RCPrimaryValueProxy {
  public RCNumberWithUnitValueProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCNumberWithUnitValue");
  }
}
