package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemFollowUpView;
import com.fudanmed.platform.core.web.shared.project.WorkItemFollowUpData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemFollowUpView.class)
public interface WorkItemFollowUpPresenterView extends ViewerWithValidation {
  public abstract WorkItemFollowUpData getValue();
  
  public abstract void setComment(final String comment);
}
