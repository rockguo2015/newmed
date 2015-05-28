package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypeView;
import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateNumberWithUnitTypeView.class)
public interface CreateOrUpdateNumberWithUnitTypePresenterView extends ViewerWithValidation {
  public abstract UINumberWithUnitType getValue();
  
  public abstract void setValue(final UINumberWithUnitType value);
}
