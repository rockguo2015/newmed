package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskManagementView;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.PatientCheckDeliverTaskEventListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = CenterlizedDeliverTaskManagementView.class)
public interface CenterlizedDeliverTaskManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final CenterlizedDeliverTaskQueryListPresenter queryListPresenter);
  
  public abstract void setPatientCheckDeliverTaskEventListPresenter(final PatientCheckDeliverTaskEventListPresenter patientCheckDeliverTaskEventListPresenter);
}
