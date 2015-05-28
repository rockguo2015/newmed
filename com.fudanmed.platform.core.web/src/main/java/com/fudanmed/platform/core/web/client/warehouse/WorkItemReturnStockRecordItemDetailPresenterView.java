package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemReturnStockRecordItemDetailView.class)
public interface WorkItemReturnStockRecordItemDetailPresenterView extends Viewer {
  public abstract void setResults(final UIWorkItemReturnStockRecord value, final Collection<UIWorkItemStockRecordItem> results);
}
