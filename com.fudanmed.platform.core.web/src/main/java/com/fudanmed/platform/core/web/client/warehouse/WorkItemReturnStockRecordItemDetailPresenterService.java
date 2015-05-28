package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailPresenterService")
public interface WorkItemReturnStockRecordItemDetailPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemStockRecordItem> loadWorkItemStockRecordItemList(final RCWorkItemReturnStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIWorkItemReturnStockRecord loadValue(final RCWorkItemReturnStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
