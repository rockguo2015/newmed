package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface StockTakingListListPresenterServiceAsync {
  public abstract void filter(final UIStockTakingListCriteria uicriteria, final AsyncCallback<IPagedResult<UIStockTakingList>> callback);
  
  public abstract void cancel(final RCStockTakingListProxy value, final AsyncCallback<Void> callback);
  
  public abstract void commit(final RCStockTakingListProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadDetails(final RCStockTakingListProxy parent, final AsyncCallback<Collection<UIStockTakingItem>> callback);
  
  public abstract void prepareExport(final RCStockTakingListProxy parent, final AsyncCallback<String> callback);
  
  public abstract void generatePrintContents(final RCStockTakingListProxy value, final AsyncCallback<String> callback);
  
  public abstract void isAllDataCollected(final RCStockTakingListProxy value, final AsyncCallback<Boolean> callback);
  
  public abstract void loadCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
}
