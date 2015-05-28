package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDevicePresenterServiceAsync {
  public abstract void loadValue(final RCDeviceProxy pvalue, final AsyncCallback<UIDevice> callback);
  
  public abstract void updateValue(final UIDevice uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDevice uivalue, final AsyncCallback<Void> callback);
}
