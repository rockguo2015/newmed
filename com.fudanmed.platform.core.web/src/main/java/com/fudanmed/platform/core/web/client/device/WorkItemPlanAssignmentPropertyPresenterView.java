package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyView1;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = WorkItemPlanAssignmentPropertyView1.class)
public interface WorkItemPlanAssignmentPropertyPresenterView extends Viewer {
  public abstract void setValue(final UIWorkItemPlanAssignment value);
  
  public abstract void clear();
}
