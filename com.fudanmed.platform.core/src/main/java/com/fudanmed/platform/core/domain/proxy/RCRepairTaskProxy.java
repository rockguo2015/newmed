package com.fudanmed.platform.core.domain.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCRepairTask")
public class RCRepairTaskProxy extends GWTNamedEntity implements IHasDocumentsProxy {
  public RCRepairTaskProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCRepairTask");
  }
}
