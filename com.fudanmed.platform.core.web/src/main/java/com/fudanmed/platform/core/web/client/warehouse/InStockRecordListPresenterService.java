package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.InStockRecordListPresenterService")
public interface InStockRecordListPresenterService extends RemoteService {
  public abstract String generatePrintContent(final RCInStockRecordProxy inStockRecord) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract IPagedResult<UIInStockRecord> filter(final UIInStockRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCInStockRecordProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIInStockRecordItem> loadDetails(final RCInStockRecordProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIInStockRecord loadInStockRecordInfo(final RCInStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
