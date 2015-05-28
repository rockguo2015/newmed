package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryView;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateDeviceTypeCategoryView.class)
public interface CreateOrUpdateDeviceTypeCategoryPresenterView extends ViewerWithValidation {
  public abstract UIDeviceTypeCategory getValue();
  
  public abstract void setParent(final RCDeviceTypeCategoryProxy parent);
  
  public abstract void setValue(final UIDeviceTypeCategory value);
}
