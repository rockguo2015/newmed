package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDocumentStorage;
import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import java.util.Collection;

public interface PictureBrowsePresenterServiceAsync {
  public abstract void loadDocumentStorageList(final IHasDocumentsProxy context, final AsyncCallback<Collection<UIDocumentStorage>> callback);
  
  public abstract void prepareDownload(final DocumentStorageProxy document, final AsyncCallback<String> callback);
}
