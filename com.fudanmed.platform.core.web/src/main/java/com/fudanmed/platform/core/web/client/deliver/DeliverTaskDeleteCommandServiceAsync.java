package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeliverTaskDeleteCommandServiceAsync {
  public abstract void deleteAll(final Collection<DLCenterlizedDeliverTaskProxy> toDeletes, final AsyncCallback<Void> callback);
}
