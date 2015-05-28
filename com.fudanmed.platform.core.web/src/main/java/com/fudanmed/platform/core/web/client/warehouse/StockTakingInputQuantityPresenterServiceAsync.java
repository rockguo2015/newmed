package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface StockTakingInputQuantityPresenterServiceAsync {
  public abstract void loadItems(final RCStockTakingListProxy takingList, final AsyncCallback<Collection<UIStockTakingItem>> callback);
  
  public abstract void updateItems(final Collection<UIStockTakingItem> items, final AsyncCallback<Void> callback);
}
