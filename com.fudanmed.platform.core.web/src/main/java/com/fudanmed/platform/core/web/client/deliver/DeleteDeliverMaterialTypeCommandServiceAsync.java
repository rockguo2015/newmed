package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteDeliverMaterialTypeCommandServiceAsync {
  public abstract void delete(final DLDeliverMaterialTypeProxy value, final AsyncCallback<Void> callback);
}
