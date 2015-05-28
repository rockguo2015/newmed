package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;

@ImplementedBy(value = CreateOrUpdateInHospitalPatientView.class)
public interface CreateOrUpdateInHospitalPatientPresenterView extends FormViewer<UIInHospitalPatient> {
  public abstract ActionContext<UIInHospitalPatient> getActionContext();
}
