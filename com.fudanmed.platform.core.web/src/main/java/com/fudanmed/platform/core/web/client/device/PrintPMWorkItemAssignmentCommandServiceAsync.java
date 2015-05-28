package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PrintPMWorkItemAssignmentCommandServiceAsync {
  public abstract void generatePrintContents(final RCPMWorkItemWorkerAssignmentProxy workItemTask, final AsyncCallback<String> callback);
}
