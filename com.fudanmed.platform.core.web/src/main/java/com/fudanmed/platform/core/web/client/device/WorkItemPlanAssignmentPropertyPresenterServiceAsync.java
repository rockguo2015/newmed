package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkItemPlanAssignmentPropertyPresenterServiceAsync {
  public abstract void loadValue(final RCWorkItemPlanAssignmentProxy value, final AsyncCallback<UIWorkItemPlanAssignment> callback);
}
