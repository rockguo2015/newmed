package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PMWorkItemWorkerAssignmentListPresenterServiceAsync {
  public abstract void loadPMWorkItemWorkerAssignmentList(final RCPMWorkItemProxy context, final AsyncCallback<Collection<UIPMWorkItemWorkerAssignment>> callback);
}
