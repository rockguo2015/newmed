package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemPendView;
import com.fudanmed.platform.core.web.shared.project.WorkItemPendData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemPendView.class)
public interface WorkItemPendPresenterView extends ViewerWithValidation {
  public abstract WorkItemPendData getValue();
  
  public abstract void setComment(final String comment);
}
