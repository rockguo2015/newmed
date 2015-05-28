package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BatchInitializePMPlanPresenterServiceAsync {
  public abstract void init4Device(final UIDeviceCriteria deviceCriteria, final BatchInitializePMPlanData data, final AsyncCallback<Void> callback);
}
