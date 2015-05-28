package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdatePMDeviceTypeEntryPresenterServiceAsync {
  public abstract void loadValue(final RCDeviceTypeProxy pvalue, final AsyncCallback<UIPMDeviceTypeEntry> callback);
  
  public abstract void updateValue(final UIPMDeviceTypeEntry uivalue, final AsyncCallback<Void> callback);
}
