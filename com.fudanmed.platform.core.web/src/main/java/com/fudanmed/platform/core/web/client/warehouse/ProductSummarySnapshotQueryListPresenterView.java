package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = ProductSummarySnapshotQueryListView.class)
public interface ProductSummarySnapshotQueryListPresenterView extends Viewer, IContextProvider<UIProductSummarySnapshotStatCriteriaData> {
  public abstract void showResults(final IPagedResult<UIProductSummarySnapshotStatCriteriaData> results);
  
  public abstract void refresh();
  
  public abstract UIProductSummarySnapshotCriteria getCriteria();
  
  public abstract void filterRequest(final RequestHandler1<UIProductSummarySnapshotCriteria> requestHandler);
  
  public abstract ActionContext<UIProductSummarySnapshotStatCriteriaData> getActionContext();
}
