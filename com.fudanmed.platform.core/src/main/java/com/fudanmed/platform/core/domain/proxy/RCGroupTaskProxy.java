package com.fudanmed.platform.core.domain.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.domain.RCGroupTask")
public class RCGroupTaskProxy extends GWTNamedEntity implements IHasDocumentsProxy {
  public RCGroupTaskProxy() {
    this.setClazzName("com.fudanmed.platform.core.domain.RCGroupTask");
  }
}
