package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PatientLocationContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLInHospitalLocationProxy>> callback);
}
