package com.fudanmed.platform.core.domain.proxy;

import com.fudanmed.platform.core.domain.proxy.RCEnterpriseProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCSupplier")
public class RCSupplierProxy extends RCEnterpriseProxy {
  public RCSupplierProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCSupplier");
  }
}
