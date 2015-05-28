package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteInHospitalPatientCommandServiceAsync {
  public abstract void delete(final DLInHospitalPatientProxy value, final AsyncCallback<Void> callback);
}
