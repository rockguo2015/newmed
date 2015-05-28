package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RemoveWorkItemPlanAssignmentCommandServiceAsync {
  public abstract void removeAssignment(final Collection<RCWorkItemPlanAssignmentProxy> assignments, final AsyncCallback<Void> callback);
}
