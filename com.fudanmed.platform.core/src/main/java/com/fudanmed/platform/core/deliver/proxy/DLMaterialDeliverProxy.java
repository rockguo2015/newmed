package com.fudanmed.platform.core.deliver.proxy;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverSubjectProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.deliver.DLMaterialDeliver")
public class DLMaterialDeliverProxy extends DLDeliverSubjectProxy {
  public DLMaterialDeliverProxy() {
    this.setClazzName("com.fudanmed.platform.core.deliver.DLMaterialDeliver");
  }
}
