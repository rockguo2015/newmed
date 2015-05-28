package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InHospitalPatientPropertyPresenterServiceAsync {
  public abstract void loadValue(final DLInHospitalPatientProxy value, final AsyncCallback<UIInHospitalPatient> callback);
}
