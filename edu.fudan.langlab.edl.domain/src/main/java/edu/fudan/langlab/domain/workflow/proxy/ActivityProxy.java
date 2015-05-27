package edu.fudan.langlab.domain.workflow.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.workflow.Activity")
public class ActivityProxy extends GWTNamedEntity {
  public ActivityProxy() {
    this.setClazzName("edu.fudan.langlab.domain.workflow.Activity");
  }
}
