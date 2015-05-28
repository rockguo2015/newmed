package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganizationCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = CheckOrganizationQueryListView.class)
public interface CheckOrganizationQueryListPresenterView extends Viewer, IContextProvider<UICheckOrganization> {
  public abstract void showResults(final IPagedResult<UICheckOrganization> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UICheckOrganizationCriteria> requestHandler);
  
  public abstract ActionContext<UICheckOrganization> getActionContext();
}
