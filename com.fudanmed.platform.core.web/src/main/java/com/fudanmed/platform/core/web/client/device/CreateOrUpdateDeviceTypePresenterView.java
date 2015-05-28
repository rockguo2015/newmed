package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeView;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateDeviceTypeView.class)
public interface CreateOrUpdateDeviceTypePresenterView extends ViewerWithValidation {
  public abstract UIDeviceType getValue();
  
  public abstract void setValue(final UIDeviceType value);
  
  public abstract void setCategory(final RCDeviceTypeCategoryProxy category);
}
