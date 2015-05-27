package com.fudanmed.platform.core.domain.proxy;

import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCWorkItemPicture")
public class RCWorkItemPictureProxy extends DocumentStorageProxy {
  public RCWorkItemPictureProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCWorkItemPicture");
  }
}
