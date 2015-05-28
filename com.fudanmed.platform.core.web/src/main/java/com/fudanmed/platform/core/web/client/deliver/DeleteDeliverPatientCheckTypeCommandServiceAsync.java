package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteDeliverPatientCheckTypeCommandServiceAsync {
  public abstract void delete(final DLDeliverPatientCheckTypeProxy value, final AsyncCallback<Void> callback);
}
