package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientView;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyPresenter;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask4Patient;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import java.util.Collection;

@ImplementedBy(value = CreateOrUpdateCenterlizedDeliverTask4PatientView.class)
public interface CreateOrUpdateCenterlizedDeliverTask4PatientPresenterView extends FormViewer<UICenterlizedDeliverTask4Patient> {
  public abstract Collection<UICenterlizedDeliverTask4Patient> getPatientDeliverList();
  
  public abstract void setCheckOrganization(final DLDeliverPatientCheckTypeProxy checkType);
  
  public abstract void showPatientDetail(final UIInHospitalPatient detail);
  
  public abstract void checkTypeChanged(final RequestHandler1<DLDeliverPatientCheckTypeProxy> requestHandler);
  
  public abstract void patientChanged(final RequestHandler1<DLInHospitalPatientProxy> requestHandler);
  
  public abstract void setInHospitalPatientPropertyPresenter(final InHospitalPatientPropertyPresenter inHospitalPatientPropertyPresenter);
}
