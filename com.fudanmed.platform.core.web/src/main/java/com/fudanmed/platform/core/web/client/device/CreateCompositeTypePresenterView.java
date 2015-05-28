package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateCompositeTypeView;
import com.fudanmed.platform.core.web.shared.device.UICompositeAttribute;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateCompositeTypeView.class)
public interface CreateCompositeTypePresenterView extends ViewerWithValidation {
  public abstract UICompositeAttribute getValue();
  
  public abstract void setSlotName(final String name);
}
