package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PMWorkItemEvaluatePropertyViewPresenterServiceAsync {
  public abstract void loadValue(final RCPMWorkItemProxy value, final AsyncCallback<UIPMWorkItemEvaluate> callback);
}
