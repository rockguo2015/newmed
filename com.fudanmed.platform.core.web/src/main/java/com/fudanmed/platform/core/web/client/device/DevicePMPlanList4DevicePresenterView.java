package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DeviceView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = DevicePMPlanList4DeviceView.class)
public interface DevicePMPlanList4DevicePresenterView extends Viewer {
  public abstract void setResults(final Collection<UIDevicePMPlan> results);
}
