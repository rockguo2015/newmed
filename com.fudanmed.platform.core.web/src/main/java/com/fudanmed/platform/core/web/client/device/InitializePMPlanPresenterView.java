package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.InitializePMPlanView;
import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Date;

@ImplementedBy(value = InitializePMPlanView.class)
public interface InitializePMPlanPresenterView extends ViewerWithValidation {
  public abstract InitializePMPlanData getValue();
  
  public abstract void setDefaultFromDate(final Date date);
}
