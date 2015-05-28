package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemOutsourceView;
import com.fudanmed.platform.core.web.shared.project.WorkItemOutsourceData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemOutsourceView.class)
public interface WorkItemOutsourcePresenterView extends ViewerWithValidation {
  public abstract WorkItemOutsourceData getValue();
  
  public abstract void setComment(final String comment);
}
