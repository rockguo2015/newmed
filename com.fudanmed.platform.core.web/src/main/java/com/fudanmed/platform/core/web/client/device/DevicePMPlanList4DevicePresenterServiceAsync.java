package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DevicePMPlanList4DevicePresenterServiceAsync {
  public abstract void loadDevicePMPlanList(final RCDeviceProxy device, final AsyncCallback<Collection<UIDevicePMPlan>> callback);
}
