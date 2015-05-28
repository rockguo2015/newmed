package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordItemDetailPresenterService")
public interface WorkItemOutStockRecordItemDetailPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemStockRecordItem> loadWorkItemStockRecordItemList(final RCWorkItemOutStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIWorkItemOutStockRecord loadValue(final RCWorkItemOutStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
