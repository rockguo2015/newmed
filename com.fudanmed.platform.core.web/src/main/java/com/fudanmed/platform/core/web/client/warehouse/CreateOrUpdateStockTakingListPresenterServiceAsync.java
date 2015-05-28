package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateStockTakingListPresenterServiceAsync {
  public abstract void loadValue(final RCStockTakingListProxy pvalue, final AsyncCallback<UIStockTakingList> callback);
  
  public abstract void updateValue(final UIStockTakingList uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIStockTakingList uivalue, final AsyncCallback<Void> callback);
  
  public abstract void loadCurrentUser(final AsyncCallback<RCEmployeeProxy> callback);
}
