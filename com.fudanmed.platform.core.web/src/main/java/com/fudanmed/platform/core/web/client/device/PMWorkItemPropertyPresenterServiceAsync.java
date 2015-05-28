package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PMWorkItemPropertyPresenterServiceAsync {
  public abstract void loadValue(final RCPMWorkItemProxy value, final AsyncCallback<UIPMWorkItem> callback);
}
