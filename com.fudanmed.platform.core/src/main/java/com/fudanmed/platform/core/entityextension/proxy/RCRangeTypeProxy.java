package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCCustomizableTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCRangeType")
public class RCRangeTypeProxy extends RCCustomizableTypeProxy {
  public RCRangeTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCRangeType");
  }
}
