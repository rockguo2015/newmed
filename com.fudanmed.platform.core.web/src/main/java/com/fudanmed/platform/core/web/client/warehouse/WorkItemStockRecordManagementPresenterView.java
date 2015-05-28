package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = WorkItemStockRecordManagementView.class)
public interface WorkItemStockRecordManagementPresenterView extends Viewer {
  public abstract void showDetail(final Collection<UIWorkItemStockRecordItem> detail);
  
  public abstract void showResults(final IPagedResult<UIWorkItemStockRecord> results);
  
  public abstract void refresh();
  
  public abstract void showDetailRequest(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIWorkItemStockRecordCriteria> requestHandler);
}
