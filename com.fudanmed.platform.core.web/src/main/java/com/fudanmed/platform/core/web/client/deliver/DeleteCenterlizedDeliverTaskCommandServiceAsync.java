package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteCenterlizedDeliverTaskCommandServiceAsync {
  public abstract void delete(final DLCenterlizedDeliverTaskProxy value, final AsyncCallback<Void> callback);
}
