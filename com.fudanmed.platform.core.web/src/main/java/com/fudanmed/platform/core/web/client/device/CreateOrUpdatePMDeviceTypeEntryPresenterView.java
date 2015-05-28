package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryView;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdatePMDeviceTypeEntryView.class)
public interface CreateOrUpdatePMDeviceTypeEntryPresenterView extends ViewerWithValidation {
  public abstract UIPMDeviceTypeEntry getValue();
  
  public abstract void setValue(final UIPMDeviceTypeEntry value);
}
