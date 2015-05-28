package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DevicePMPlanAssignmentListPresenterServiceAsync {
  public abstract void loadDevicePlanAssignmentList(final RCDeviceProxy context, final AsyncCallback<Collection<UIWorkItemPlanAssignment>> callback);
}
