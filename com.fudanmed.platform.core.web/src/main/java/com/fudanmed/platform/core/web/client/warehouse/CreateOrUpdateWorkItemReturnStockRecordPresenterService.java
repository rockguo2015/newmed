package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemReturnStockRecordPresenterService")
public interface CreateOrUpdateWorkItemReturnStockRecordPresenterService extends RemoteService {
  public abstract UIWorkItemReturnStockRecord loadValue(final RCWorkItemReturnStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCWorkItemReturnStockRecordProxy createValue(final UIWorkItemReturnStockRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCRepairTaskProxy getRepairTask(final RCWorkItemTaskProxy workItem) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy getCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCWorkItemReturnStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
