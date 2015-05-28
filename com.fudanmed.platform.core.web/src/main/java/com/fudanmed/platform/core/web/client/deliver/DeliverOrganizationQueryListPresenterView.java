package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganizationCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = DeliverOrganizationQueryListView.class)
public interface DeliverOrganizationQueryListPresenterView extends Viewer, IContextProvider<UIDeliverOrganization> {
  public abstract void showResults(final IPagedResult<UIDeliverOrganization> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIDeliverOrganizationCriteria> requestHandler);
  
  public abstract ActionContext<UIDeliverOrganization> getActionContext();
}
