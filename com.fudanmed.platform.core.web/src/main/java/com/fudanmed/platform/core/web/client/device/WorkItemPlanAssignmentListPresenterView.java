package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = WorkItemPlanAssignmentListView.class)
public interface WorkItemPlanAssignmentListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWorkItemPlanAssignment> results);
  
  public abstract ActionContext<UIWorkItemPlanAssignment> getActionContext();
  
  public abstract void supportMultiSelect(final Boolean support);
  
  public abstract Collection<UIWorkItemPlanAssignment> getSelectedValues();
}
