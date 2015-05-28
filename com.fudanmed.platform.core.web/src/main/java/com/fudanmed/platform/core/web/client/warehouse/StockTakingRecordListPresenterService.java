package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordListPresenterService")
public interface StockTakingRecordListPresenterService extends RemoteService {
  public abstract IPagedResult<UIStockTakingRecord> filter(final UIStockTakingRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCStockTakingRecordProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIStockTakingRecordItem> loadDetails(final RCStockTakingRecordProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIStockTakingRecord loadStockTakingRecordInfo(final RCStockTakingRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
