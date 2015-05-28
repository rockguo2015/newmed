package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.OutStockRecordItemDetailPresenterService")
public interface OutStockRecordItemDetailPresenterService extends RemoteService {
  public abstract Collection<UIOutStockRecordItem> loadWorkItemStockRecordItemList(final RCOutStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIOutStockRecord loadValue(final RCOutStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
