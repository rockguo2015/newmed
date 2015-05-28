package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingListListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ImplementedBy(value = StockTakingListListView.class)
public interface StockTakingListListPresenterView extends Viewer {
  public abstract void setSourceWarehouseContext(final RCEmployeeProxy employee, final Procedure1<? super Void> notifier);
  
  public abstract void showResults(final IPagedResult<UIStockTakingList> results);
  
  public abstract void showDetails(final Collection<UIStockTakingItem> details);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIStockTakingListCriteria> requestHandler);
  
  public abstract void createStockTakingListRequest(final RequestHandler requestHandler);
  
  public abstract void cancelStockTakingListRequest(final RequestHandler1<RCStockTakingListProxy> requestHandler);
  
  public abstract void inputQuantity(final RequestHandler1<RCStockTakingListProxy> requestHandler);
  
  public abstract void commit(final RequestHandler1<RCStockTakingListProxy> requestHandler);
  
  public abstract void export(final RequestHandler1<RCStockTakingListProxy> requestHandler);
  
  public abstract void showDetailRequest(final RequestHandler1<RCStockTakingListProxy> requestHandler);
  
  public abstract void printListlRequest(final RequestHandler1<RCStockTakingListProxy> requestHandler);
}
