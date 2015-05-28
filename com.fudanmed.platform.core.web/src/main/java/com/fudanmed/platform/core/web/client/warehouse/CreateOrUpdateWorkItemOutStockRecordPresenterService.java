package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWorkItemOutStockRecordPresenterService")
public interface CreateOrUpdateWorkItemOutStockRecordPresenterService extends RemoteService {
  public abstract UIProductWarehouseStorageSummary getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIWorkItemOutStockRecord loadValue(final RCWorkItemOutStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCWorkItemOutStockRecordProxy createValue(final UIWorkItemOutStockRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCRepairTaskProxy getRepairTask(final RCWorkItemTaskProxy workItem) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generateFitPrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCWorkItemOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy getCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
