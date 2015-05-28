package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemDetailView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = StockTakingRecordItemDetailView.class)
public interface StockTakingRecordItemDetailPresenterView extends Viewer {
  public abstract void setResults(final UIStockTakingRecord value, final Collection<UIStockTakingRecordItem> results);
  
  public abstract void print(final RequestHandler requestHandler);
}
