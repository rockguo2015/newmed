package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDevicePMPlanPresenterServiceAsync {
  public abstract void loadValue(final RCDevicePMPlanProxy pvalue, final AsyncCallback<UIDevicePMPlan> callback);
  
  public abstract void updateValue(final UIDevicePMPlan uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDevicePMPlan uivalue, final RCDevicePMSpecificationProxy parent, final AsyncCallback<Void> callback);
}
