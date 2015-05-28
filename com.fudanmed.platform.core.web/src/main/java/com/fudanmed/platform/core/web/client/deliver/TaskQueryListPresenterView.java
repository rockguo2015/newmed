package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.TaskQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = TaskQueryListView.class)
public interface TaskQueryListPresenterView extends Viewer, IContextProvider<UITask> {
  public abstract void showResults(final IPagedResult<UITask> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UITaskCriteria> requestHandler);
  
  public abstract ActionContext<UITask> getActionContext();
}
