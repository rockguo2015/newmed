package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeleteDevicePMPlanCommandServiceAsync {
  public abstract void doDelete(final Collection<RCDevicePMPlanProxy> plans, final AsyncCallback<Void> callback);
}
