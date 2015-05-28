package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;

public interface CreateOrUpdateDocumentStoragePresenterServiceAsync {
  public abstract void loadValue(final DocumentStorageProxy pvalue, final AsyncCallback<UIDocumentStorage> callback);
  
  public abstract void updateValue(final UIDocumentStorage uivalue, final AsyncCallback<Void> callback);
  
  public abstract void create(final IDocumentContainerProxy documentContainer, final UIDocumentStorage uivalue, final AsyncCallback<Void> callback);
}
