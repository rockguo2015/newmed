package com.fudanmed.platform.core.web.client.device;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;

public interface DeletePictureCommandServiceAsync {
  public abstract void delete(final DocumentStorageProxy value, final AsyncCallback<Void> callback);
}
