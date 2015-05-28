package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CreateOrUpdateCenterlizedDeliverTask4PatientPresenterServiceAsync {
  public abstract void loadValue(final DLCenterlizedDeliverTaskProxy pvalue, final AsyncCallback<UICenterlizedDeliverTask4Patient> callback);
  
  public abstract void updateValue(final UICenterlizedDeliverTask4Patient uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UICenterlizedDeliverTask4Patient uivalue, final Collection<UICenterlizedDeliverTask4Patient> patients, final AsyncCallback<Void> callback);
  
  public abstract void loadPatientDetail(final DLInHospitalPatientProxy newPatient, final AsyncCallback<UIInHospitalPatient> callback);
}
