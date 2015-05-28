package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OnsitePositionManagementPresenterServiceAsync {
  public abstract void delete(final RCOnsitePositionProxy value, final AsyncCallback<Void> callback);
}
