package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordItemDetailView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = OutStockRecordItemDetailView.class)
public interface OutStockRecordItemDetailPresenterView extends Viewer {
  public abstract void setResults(final UIOutStockRecord value, final Collection<UIOutStockRecordItem> results);
  
  public abstract void print(final RequestHandler requestHandler);
}
