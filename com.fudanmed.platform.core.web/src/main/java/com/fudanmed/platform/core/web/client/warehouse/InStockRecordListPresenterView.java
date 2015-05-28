package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.InStockRecordListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = InStockRecordListView.class)
public interface InStockRecordListPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIInStockRecord> results);
  
  public abstract void showDetails(final UIInStockRecord detail, final Collection<UIInStockRecordItem> details);
  
  public abstract void refresh();
  
  public abstract void inStockRequest(final RequestHandler requestHandler);
  
  public abstract void modifyInStockRequest(final RequestHandler1<RCInStockRecordProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIInStockRecordCriteria> requestHandler);
  
  public abstract void showDetailRequest(final RequestHandler1<RCInStockRecordProxy> requestHandler);
  
  public abstract void print(final RequestHandler1<RCInStockRecordProxy> requestHandler);
}
