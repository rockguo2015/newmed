package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DevicePMPlanListPresenterServiceAsync {
  public abstract void loadDevicePMPlanList(final RCDevicePMSpecificationProxy context, final AsyncCallback<Collection<UIDevicePMPlan>> callback);
  
  public abstract void loadDevicePMPlanList4Device(final RCDeviceProxy context, final AsyncCallback<Collection<UIDevicePMPlan>> callback);
}
