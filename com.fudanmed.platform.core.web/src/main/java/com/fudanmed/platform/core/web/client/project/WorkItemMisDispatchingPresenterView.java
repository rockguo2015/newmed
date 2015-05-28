package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemMisDispatchingView;
import com.fudanmed.platform.core.web.shared.project.WorkItemMisDispatchingData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = WorkItemMisDispatchingView.class)
public interface WorkItemMisDispatchingPresenterView extends ViewerWithValidation {
  public abstract WorkItemMisDispatchingData getValue();
  
  public abstract void setComment(final String comment);
  
  public abstract void canReport();
}
