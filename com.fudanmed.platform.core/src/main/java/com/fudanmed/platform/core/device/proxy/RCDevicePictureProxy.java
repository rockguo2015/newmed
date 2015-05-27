package com.fudanmed.platform.core.device.proxy;

import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.device.RCDevicePicture")
public class RCDevicePictureProxy extends DocumentStorageProxy {
  public RCDevicePictureProxy() {
    this.setClazzName("com.fudanmed.platform.core.device.RCDevicePicture");
  }
}
