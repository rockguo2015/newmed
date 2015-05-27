package com.fudanmed.platform.core.common.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.common.RCWorkType")
public class RCWorkTypeProxy extends CodeProxy {
  public RCWorkTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.common.RCWorkType");
  }
}
