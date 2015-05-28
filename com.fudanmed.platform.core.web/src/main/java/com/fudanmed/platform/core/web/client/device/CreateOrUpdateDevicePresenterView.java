package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateDeviceView.class)
public interface CreateOrUpdateDevicePresenterView extends ViewerWithValidation {
  public abstract UIDevice getValue();
  
  public abstract void setValue(final UIDevice value);
  
  public abstract void setDeviceType(final RCDeviceTypeProxy deviceType);
  
  public abstract void setLocation(final UIOnsitePosition location);
}
