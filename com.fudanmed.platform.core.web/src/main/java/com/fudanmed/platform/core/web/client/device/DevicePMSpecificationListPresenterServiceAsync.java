package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DevicePMSpecificationListPresenterServiceAsync {
  public abstract void loadDevicePMSpecificationList(final RCDeviceProxy context, final AsyncCallback<Collection<UIDevicePMSpecification>> callback);
}
