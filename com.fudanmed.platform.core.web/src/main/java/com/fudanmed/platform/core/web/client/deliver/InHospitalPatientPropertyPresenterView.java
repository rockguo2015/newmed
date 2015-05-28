package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientPropertyView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = InHospitalPatientPropertyView.class)
public interface InHospitalPatientPropertyPresenterView extends Viewer {
  public abstract void setValue(final UIInHospitalPatient value);
  
  public abstract void clear();
}
