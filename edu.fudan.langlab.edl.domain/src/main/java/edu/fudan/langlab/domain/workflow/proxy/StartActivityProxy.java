package edu.fudan.langlab.domain.workflow.proxy;

import edu.fudan.langlab.domain.workflow.proxy.ActivityProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.workflow.StartActivity")
public class StartActivityProxy extends ActivityProxy {
  public StartActivityProxy() {
    this.setClazzName("edu.fudan.langlab.domain.workflow.StartActivity");
  }
}
