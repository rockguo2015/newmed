package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLTaskSourceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLTaskSource4HISImport")
public class DLTaskSource4HISImportProxy extends DLTaskSourceProxy {
  public DLTaskSource4HISImportProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLTaskSource4HISImport");
  }
}
