package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingList;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingListCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.StockTakingListListPresenterService")
public interface StockTakingListListPresenterService extends RemoteService {
  public abstract IPagedResult<UIStockTakingList> filter(final UIStockTakingListCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void cancel(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void commit(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIStockTakingItem> loadDetails(final RCStockTakingListProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String prepareExport(final RCStockTakingListProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean isAllDataCollected(final RCStockTakingListProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
