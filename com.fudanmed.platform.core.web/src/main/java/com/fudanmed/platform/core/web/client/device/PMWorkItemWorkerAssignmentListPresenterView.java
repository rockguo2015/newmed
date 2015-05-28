package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = PMWorkItemWorkerAssignmentListView.class)
public interface PMWorkItemWorkerAssignmentListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIPMWorkItemWorkerAssignment> results);
  
  public abstract ActionContext<UIPMWorkItemWorkerAssignment> getActionContext();
}
