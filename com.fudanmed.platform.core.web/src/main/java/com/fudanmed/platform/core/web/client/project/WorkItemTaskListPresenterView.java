package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemTaskListView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = WorkItemTaskListView.class)
public interface WorkItemTaskListPresenterView extends Viewer {
  public abstract void showResults(final Collection<UIWorkItemTask> result);
  
  public abstract ActionContext<UIWorkItemTask> getActionContext();
}
