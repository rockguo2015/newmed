package edu.fudan.langlab.domain.document.proxy;

import com.uniquesoft.gwt.shared.GWTNamedEntity;
import edu.fudan.langlab.domain.document.proxy.IDocumentProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.document.DocumentStorage")
public class DocumentStorageProxy extends GWTNamedEntity implements IDocumentProxy {
  public DocumentStorageProxy() {
    this.setClazzName("edu.fudan.langlab.domain.document.DocumentStorage");
  }
}
