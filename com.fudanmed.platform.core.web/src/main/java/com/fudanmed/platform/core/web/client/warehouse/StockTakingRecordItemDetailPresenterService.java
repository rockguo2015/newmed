package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemDetailPresenterService")
public interface StockTakingRecordItemDetailPresenterService extends RemoteService {
  public abstract Collection<UIStockTakingRecordItem> loadWorkItemStockRecordItemList(final RCStockTakingRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIStockTakingRecord loadValue(final RCStockTakingRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCStockTakingRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
