package com.fudanmed.platform.core.deliver.proxy;

import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLResourceType")
public class DLResourceTypeProxy extends CodeProxy {
  public DLResourceTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLResourceType");
  }
}
