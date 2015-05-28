package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeliverPatientCheckTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLDeliverPatientCheckTypeProxy>> callback);
}
