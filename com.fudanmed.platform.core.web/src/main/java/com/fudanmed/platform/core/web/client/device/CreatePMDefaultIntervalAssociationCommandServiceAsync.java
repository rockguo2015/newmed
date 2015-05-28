package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreatePMDefaultIntervalAssociationCommandServiceAsync {
  public abstract void getRCPMDeviceTypeEntry(final RCDeviceTypeProxy deviceType, final AsyncCallback<RCPMDeviceTypeEntryProxy> callback);
}
