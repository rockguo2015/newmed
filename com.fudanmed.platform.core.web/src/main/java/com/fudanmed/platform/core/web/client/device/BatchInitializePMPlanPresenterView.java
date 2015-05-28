package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanView;
import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = BatchInitializePMPlanView.class)
public interface BatchInitializePMPlanPresenterView extends ViewerWithValidation {
  public abstract BatchInitializePMPlanData getValue();
}
