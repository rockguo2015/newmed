package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface InHospitalPatientContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLInHospitalPatientProxy>> callback);
}
