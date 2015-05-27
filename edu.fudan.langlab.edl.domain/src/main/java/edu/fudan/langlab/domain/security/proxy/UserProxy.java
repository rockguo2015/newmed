package edu.fudan.langlab.domain.security.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.security.User")
public class UserProxy extends GWTNamedEntity {
  public UserProxy() {
    this.setClazzName("edu.fudan.langlab.domain.security.User");
  }
}
