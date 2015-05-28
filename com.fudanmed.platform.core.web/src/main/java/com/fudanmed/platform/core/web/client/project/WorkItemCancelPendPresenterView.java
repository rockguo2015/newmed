package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemCancelPendView;
import com.fudanmed.platform.core.web.shared.project.WorkItemCancelPendData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemCancelPendView.class)
public interface WorkItemCancelPendPresenterView extends ViewerWithValidation {
  public abstract WorkItemCancelPendData getValue();
  
  public abstract void setComment(final String comment);
  
  public abstract void canReport();
}
