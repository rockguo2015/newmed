package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteDeliverOrganizationCommandServiceAsync {
  public abstract void delete(final DLDeliverOrganizationProxy value, final AsyncCallback<Void> callback);
}
