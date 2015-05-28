package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckTypeCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = DeliverPatientCheckTypeQueryListView.class)
public interface DeliverPatientCheckTypeQueryListPresenterView extends Viewer, IContextProvider<UIDeliverPatientCheckType> {
  public abstract void showResults(final IPagedResult<UIDeliverPatientCheckType> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIDeliverPatientCheckTypeCriteria> requestHandler);
  
  public abstract ActionContext<UIDeliverPatientCheckType> getActionContext();
  
  public abstract void setCategoryAC(final ActionContext<DLDeliverPatientCheckCategoryProxy> categoryAC);
}
