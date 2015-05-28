package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialTypeCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = DeliverMaterialTypeQueryListView.class)
public interface DeliverMaterialTypeQueryListPresenterView extends Viewer, IContextProvider<UIDeliverMaterialType> {
  public abstract void showResults(final IPagedResult<UIDeliverMaterialType> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIDeliverMaterialTypeCriteria> requestHandler);
  
  public abstract ActionContext<UIDeliverMaterialType> getActionContext();
  
  public abstract void setCategoryAC(final ActionContext<DLDeliverMaterialCategoryProxy> categoryAC);
}
