package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = CenterlizedDeliverTaskQueryListView.class)
public interface CenterlizedDeliverTaskQueryListPresenterView extends Viewer, IContextProvider<UICenterlizedDeliverTask> {
  public abstract void showResults(final IPagedResult<UICenterlizedDeliverTask> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UICenterlizedDeliverTaskCriteria> requestHandler);
  
  public abstract ActionContext<UICenterlizedDeliverTask> getActionContext();
}
