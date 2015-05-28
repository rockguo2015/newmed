package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = WorkItemOutStockRecordListView.class)
public interface WorkItemOutStockRecordListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWorkItemStockRecord> results);
  
  public abstract ActionContext<UIWorkItemStockRecord> getActionContext();
}
