package edu.fudan.langlab.domain.organization.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.organization.Party")
public class PartyProxy extends GWTNamedEntity {
  public PartyProxy() {
    this.setClazzName("edu.fudan.langlab.domain.organization.Party");
  }
}
