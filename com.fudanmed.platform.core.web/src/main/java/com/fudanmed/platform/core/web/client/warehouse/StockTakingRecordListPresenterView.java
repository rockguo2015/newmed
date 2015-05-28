package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = StockTakingRecordListView.class)
public interface StockTakingRecordListPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIStockTakingRecord> results);
  
  public abstract void showDetails(final UIStockTakingRecord detail, final Collection<UIStockTakingRecordItem> details);
  
  public abstract void refresh();
  
  public abstract void StockTakingRequest(final RequestHandler requestHandler);
  
  public abstract void modifyStockTakingRequest(final RequestHandler1<RCStockTakingRecordProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIStockTakingRecordCriteria> requestHandler);
  
  public abstract void showDetailRequest(final RequestHandler1<RCStockTakingRecordProxy> requestHandler);
}
