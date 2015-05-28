package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeliverEmergencyContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLDeliverEmergencyProxy>> callback);
}
