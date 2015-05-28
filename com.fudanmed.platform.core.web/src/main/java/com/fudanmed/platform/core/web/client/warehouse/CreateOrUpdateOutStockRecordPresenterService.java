package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateOutStockRecordPresenterService")
public interface CreateOrUpdateOutStockRecordPresenterService extends RemoteService {
  public abstract UIProductWarehouseStorageSummary getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIOutStockRecord loadValue(final RCOutStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIOutStockRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOrganizationProxy loadOrganization(final RCMaintenanceTeamProxy team) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOutStockRecordProxy createValue(final UIOutStockRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCWarehouseProxy getHostWarehouse() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCOutStockRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
