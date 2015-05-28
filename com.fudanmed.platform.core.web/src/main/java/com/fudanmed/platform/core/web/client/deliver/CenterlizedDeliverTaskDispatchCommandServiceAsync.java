package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CenterlizedDeliverTaskDispatchCommandServiceAsync {
  public abstract void accept(final DLCenterlizedDeliverTaskProxy value, final AsyncCallback<Void> callback);
}
