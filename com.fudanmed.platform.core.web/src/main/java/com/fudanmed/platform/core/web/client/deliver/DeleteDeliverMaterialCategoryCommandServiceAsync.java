package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteDeliverMaterialCategoryCommandServiceAsync {
  public abstract void delete(final DLDeliverMaterialCategoryProxy value, final AsyncCallback<Void> callback);
}
