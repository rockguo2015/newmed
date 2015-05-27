package com.fudanmed.platform.core.device.proxy;

import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.device.RCDeviceFile")
public class RCDeviceFileProxy extends DocumentStorageProxy {
  public RCDeviceFileProxy() {
    this.setClazzName("com.fudanmed.platform.core.device.RCDeviceFile");
  }
}
