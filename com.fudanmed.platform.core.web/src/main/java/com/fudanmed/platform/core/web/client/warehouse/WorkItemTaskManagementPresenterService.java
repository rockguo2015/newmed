package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementPresenterService")
public interface WorkItemTaskManagementPresenterService extends RemoteService {
  public abstract String generatePrintContents(final RCWorkItemStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generateOutFitPrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract IPagedResult<UIWorkItemTask> filter(final UIWorkItemTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCWorkItemTaskProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean isOutStock(final RCWorkItemStockRecordProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
