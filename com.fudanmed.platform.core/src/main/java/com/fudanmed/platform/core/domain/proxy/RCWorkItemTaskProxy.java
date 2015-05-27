package com.fudanmed.platform.core.domain.proxy;

import com.fudanmed.platform.core.warehouse.proxy.RCRCProductStorageContainerProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCWorkItemTask")
public class RCWorkItemTaskProxy extends RCRCProductStorageContainerProxy implements IDocumentContainerProxy {
  public RCWorkItemTaskProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCWorkItemTask");
  }
}
