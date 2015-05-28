package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;

public interface InitializePMPlanPresenterServiceAsync {
  public abstract void init4Device(final InitializePMPlanData data, final RCDevicePMSpecificationProxy devicePMSpec, final AsyncCallback<Void> callback);
  
  public abstract void loadDefaultFromDate(final RCDevicePMSpecificationProxy devicePMSpec, final AsyncCallback<Date> callback);
}
