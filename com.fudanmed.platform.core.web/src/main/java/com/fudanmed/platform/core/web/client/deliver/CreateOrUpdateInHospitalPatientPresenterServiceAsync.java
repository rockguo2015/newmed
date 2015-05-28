package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateInHospitalPatientPresenterServiceAsync {
  public abstract void loadValue(final DLInHospitalPatientProxy pvalue, final AsyncCallback<UIInHospitalPatient> callback);
  
  public abstract void updateValue(final UIInHospitalPatient uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIInHospitalPatient uivalue, final AsyncCallback<DLInHospitalPatientProxy> callback);
}
