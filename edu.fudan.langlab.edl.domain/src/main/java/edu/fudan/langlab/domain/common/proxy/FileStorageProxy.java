package edu.fudan.langlab.domain.common.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.common.FileStorage")
public class FileStorageProxy extends GWTNamedEntity {
  public FileStorageProxy() {
    this.setClazzName("edu.fudan.langlab.domain.common.FileStorage");
  }
}
