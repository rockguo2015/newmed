package com.fudanmed.platform.core.device.proxy;

import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.device.RCDeviceTypeFile")
public class RCDeviceTypeFileProxy extends DocumentStorageProxy {
  public RCDeviceTypeFileProxy() {
    this.setClazzName("com.fudanmed.platform.core.device.RCDeviceTypeFile");
  }
}
