package edu.fudan.langlab.domain.security.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.security.UserRoleAssignment")
public class UserRoleAssignmentProxy extends GWTNamedEntity {
  public UserRoleAssignmentProxy() {
    this.setClazzName("edu.fudan.langlab.domain.security.UserRoleAssignment");
  }
}
