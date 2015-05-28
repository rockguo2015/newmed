package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = OutStockRecordListView.class)
public interface OutStockRecordListPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIOutStockRecord> results);
  
  public abstract void showDetails(final UIOutStockRecord detail, final Collection<UIOutStockRecordItem> details);
  
  public abstract void refresh();
  
  public abstract void OutStockRequest(final RequestHandler requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIOutStockRecordCriteria> requestHandler);
  
  public abstract void showDetailRequest(final RequestHandler1<RCOutStockRecordProxy> requestHandler);
  
  public abstract void print(final RequestHandler1<RCOutStockRecordProxy> requestHandler);
}
