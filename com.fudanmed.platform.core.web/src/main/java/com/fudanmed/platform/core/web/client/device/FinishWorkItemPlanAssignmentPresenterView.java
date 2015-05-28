package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = FinishWorkItemPlanAssignmentView.class)
public interface FinishWorkItemPlanAssignmentPresenterView extends ViewerWithValidation {
  public abstract UIWorkItemPlanAssignmentFinishData getValue();
}
