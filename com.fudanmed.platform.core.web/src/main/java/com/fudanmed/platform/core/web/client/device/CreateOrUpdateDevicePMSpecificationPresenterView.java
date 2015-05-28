package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMSpecificationView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateDevicePMSpecificationView.class)
public interface CreateOrUpdateDevicePMSpecificationPresenterView extends ViewerWithValidation {
  public abstract UIDevicePMSpecification getValue();
  
  public abstract void setValue(final UIDevicePMSpecification value);
  
  public abstract void setDevice(final RCDeviceProxy device);
}
