package edu.fudan.langlab.domain.code.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.code.Code")
public class CodeProxy extends GWTNamedEntity {
  public CodeProxy() {
    this.setClazzName("edu.fudan.langlab.domain.code.Code");
  }
}
