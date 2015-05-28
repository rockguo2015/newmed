package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypeView;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryAttribute;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreatePrimaryTypeView.class)
public interface CreatePrimaryTypePresenterView extends ViewerWithValidation {
  public abstract UIPrimaryAttribute getValue();
  
  public abstract void setSlotName(final String name);
}
