package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PatientDeliverMethodContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLPatientDeliverMethodProxy>> callback);
}
