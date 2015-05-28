package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPendView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdatePMWorkItemWorkerAssignmentPendView.class)
public interface CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterView extends ViewerWithValidation {
  public abstract UIPMWorkItemWorkerAssignment getValue();
  
  public abstract void setValue(final UIPMWorkItemWorkerAssignment value);
}
