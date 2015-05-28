package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteCheckOrganizationCommandServiceAsync {
  public abstract void delete(final DLCheckOrganizationProxy value, final AsyncCallback<Void> callback);
}
