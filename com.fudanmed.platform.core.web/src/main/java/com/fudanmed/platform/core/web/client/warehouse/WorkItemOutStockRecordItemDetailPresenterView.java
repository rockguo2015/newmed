package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordItemDetailView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemOutStockRecordItemDetailView.class)
public interface WorkItemOutStockRecordItemDetailPresenterView extends Viewer {
  public abstract void setResults(final UIWorkItemOutStockRecord value, final Collection<UIWorkItemStockRecordItem> results);
  
  public abstract void print(final RequestHandler requestHandler);
}
