package edu.fudan.langlab.domain.workflow.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.workflow.BusinessProcess")
public class BusinessProcessProxy extends GWTNamedEntity {
  public BusinessProcessProxy() {
    this.setClazzName("edu.fudan.langlab.domain.workflow.BusinessProcess");
  }
}
