package com.fudanmed.platform.core.entityextension.proxy;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.entityextension.RCCustomizableType")
public class RCCustomizableTypeProxy extends RCPrimaryTypeProxy {
  public RCCustomizableTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.entityextension.RCCustomizableType");
  }
}
