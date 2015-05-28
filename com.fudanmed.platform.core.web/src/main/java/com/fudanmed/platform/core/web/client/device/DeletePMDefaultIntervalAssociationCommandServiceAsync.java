package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeletePMDefaultIntervalAssociationCommandServiceAsync {
  public abstract void delete(final RCPMDefaultIntervalAssociationProxy value, final AsyncCallback<Void> callback);
}
