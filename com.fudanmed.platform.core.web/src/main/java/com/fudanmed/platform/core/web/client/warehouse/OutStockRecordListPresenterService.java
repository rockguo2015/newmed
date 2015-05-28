package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.OutStockRecordListPresenterService")
public interface OutStockRecordListPresenterService extends RemoteService {
  public abstract String generatePrintContents(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract IPagedResult<UIOutStockRecord> filter(final UIOutStockRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCOutStockRecordProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIOutStockRecordItem> loadDetails(final RCOutStockRecordProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIOutStockRecord loadOutStockRecordInfo(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
