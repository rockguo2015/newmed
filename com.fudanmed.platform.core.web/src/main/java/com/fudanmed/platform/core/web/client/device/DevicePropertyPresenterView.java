package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePropertyView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = DevicePropertyView.class)
public interface DevicePropertyPresenterView extends Viewer {
  public abstract void setValue(final UIDevice value);
}
