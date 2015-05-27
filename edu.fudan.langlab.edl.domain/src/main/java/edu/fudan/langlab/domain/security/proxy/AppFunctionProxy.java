package edu.fudan.langlab.domain.security.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.security.AppFunction")
public class AppFunctionProxy extends GWTNamedEntity {
  public AppFunctionProxy() {
    this.setClazzName("edu.fudan.langlab.domain.security.AppFunction");
  }
}
