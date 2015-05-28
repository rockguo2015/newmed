package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourceView;
import com.fudanmed.platform.core.web.shared.project.WorkItemFinishOutsourceData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemFinishOutsourceView.class)
public interface WorkItemFinishOutsourcePresenterView extends ViewerWithValidation {
  public abstract WorkItemFinishOutsourceData getValue();
  
  public abstract void setComment(final String comment);
  
  public abstract void canReport();
}
