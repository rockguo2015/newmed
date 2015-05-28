package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMEngineerReportView;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = PMEngineerReportView.class)
public interface PMEngineerReportPresenterView extends Viewer {
  public abstract void setWorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter);
}
