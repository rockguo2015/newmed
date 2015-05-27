package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCNumberWithUnitType")
public class RCNumberWithUnitTypeProxy extends RCCustomizableTypeProxy {
  public RCNumberWithUnitTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCNumberWithUnitType");
  }
}
