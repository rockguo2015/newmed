package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface FinishWorkItemPlanAssignmentPresenterServiceAsync {
  public abstract void createValue(final UIWorkItemPlanAssignmentFinishData uivalue, final Collection<RCWorkItemPlanAssignmentProxy> parents, final AsyncCallback<Void> callback);
}
