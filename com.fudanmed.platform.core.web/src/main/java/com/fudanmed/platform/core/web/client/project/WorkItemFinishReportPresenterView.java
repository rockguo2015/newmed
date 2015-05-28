package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemFinishReportView;
import com.fudanmed.platform.core.web.shared.project.WorkItemFinishReportData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemFinishReportView.class)
public interface WorkItemFinishReportPresenterView extends ViewerWithValidation {
  public abstract WorkItemFinishReportData getValue();
  
  public abstract void setComment(final String comment);
  
  public abstract void canReport();
}
