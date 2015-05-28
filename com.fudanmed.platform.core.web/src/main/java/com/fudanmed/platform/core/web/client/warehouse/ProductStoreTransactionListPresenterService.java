package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;
import java.util.Date;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterService")
public interface ProductStoreTransactionListPresenterService extends RemoteService {
  public abstract Collection<UIProductStoreTransaction> loadProductStoreTransactionList(final RCProductStorageProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIProductStoreTransaction> loadProductStoreTransactionList4Summary(final RCProductWarehouseStorageSummaryProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIProductStoreTransaction> loadProductStoreTransactionList4Summary(final RCProductWarehouseStorageSummaryProxy context, final Date dateFrom, final Date dateTo) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
