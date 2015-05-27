package edu.fudan.langlab.domain.document.proxy;

import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("edu.fudan.langlab.domain.document.IDocumentContainer")
public interface IDocumentContainerProxy extends IHasDocumentsProxy {
}
