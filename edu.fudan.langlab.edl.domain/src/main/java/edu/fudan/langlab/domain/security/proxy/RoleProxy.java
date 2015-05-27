package edu.fudan.langlab.domain.security.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.security.Role")
public class RoleProxy extends GWTNamedEntity {
  public RoleProxy() {
    this.setClazzName("edu.fudan.langlab.domain.security.Role");
  }
}
