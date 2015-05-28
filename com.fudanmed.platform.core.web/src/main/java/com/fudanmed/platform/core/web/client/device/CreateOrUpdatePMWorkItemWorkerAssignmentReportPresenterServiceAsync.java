package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterServiceAsync {
  public abstract void loadValue(final RCPMWorkItemWorkerAssignmentProxy pvalue, final AsyncCallback<UIPMWorkItemWorkerAssignment> callback);
  
  public abstract void updateValue(final UIPMWorkItemWorkerAssignment uivalue, final AsyncCallback<Void> callback);
  
  public abstract void allWorkFinishedExceptThis(final RCPMWorkItemWorkerAssignmentProxy uivalue, final AsyncCallback<Boolean> callback);
}
