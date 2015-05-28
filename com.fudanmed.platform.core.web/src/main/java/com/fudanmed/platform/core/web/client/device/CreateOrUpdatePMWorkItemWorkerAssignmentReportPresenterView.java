package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentReportView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdatePMWorkItemWorkerAssignmentReportView.class)
public interface CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView extends ViewerWithValidation {
  public abstract UIPMWorkItemWorkerAssignment getValue();
  
  public abstract void setValue(final UIPMWorkItemWorkerAssignment value);
  
  public abstract void setCanFinish(final Boolean v);
}
