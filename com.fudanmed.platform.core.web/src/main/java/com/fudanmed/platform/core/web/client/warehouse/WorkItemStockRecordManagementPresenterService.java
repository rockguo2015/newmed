package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordManagementPresenterService")
public interface WorkItemStockRecordManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIWorkItemStockRecord> filter(final UIWorkItemStockRecordCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIWorkItemStockRecordItem> loadDetail(final RCWorkItemStockRecordProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
