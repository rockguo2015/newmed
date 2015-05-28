package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteDeliverPatientCheckCategoryCommandServiceAsync {
  public abstract void delete(final DLDeliverPatientCheckCategoryProxy value, final AsyncCallback<Void> callback);
}
