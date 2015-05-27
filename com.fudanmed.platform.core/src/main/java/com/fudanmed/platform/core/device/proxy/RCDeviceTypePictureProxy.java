package com.fudanmed.platform.core.device.proxy;

import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.device.RCDeviceTypePicture")
public class RCDeviceTypePictureProxy extends DocumentStorageProxy {
  public RCDeviceTypePictureProxy() {
    this.setClazzName("com.fudanmed.platform.core.device.RCDeviceTypePicture");
  }
}
