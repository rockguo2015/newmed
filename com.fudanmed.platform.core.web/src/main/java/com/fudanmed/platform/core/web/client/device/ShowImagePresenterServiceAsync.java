package com.fudanmed.platform.core.web.client.device;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.document.proxy.IDocumentProxy;

public interface ShowImagePresenterServiceAsync {
  public abstract void prepareDownload(final IDocumentProxy document, final AsyncCallback<String> callback);
}
