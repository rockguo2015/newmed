package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenterService")
public interface StockTakingInputQuantityPresenterService extends RemoteService {
  public abstract Collection<UIStockTakingItem> loadItems(final RCStockTakingListProxy takingList) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateItems(final Collection<UIStockTakingItem> items) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
