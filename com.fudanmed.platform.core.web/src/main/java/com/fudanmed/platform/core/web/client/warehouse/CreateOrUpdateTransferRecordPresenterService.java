package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCTransferRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UITransferRecord;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateTransferRecordPresenterService")
public interface CreateOrUpdateTransferRecordPresenterService extends RemoteService {
  public abstract UIProductWarehouseStorageSummary getProductSummaryByProductSid(final String sid, final RCWarehouseProxy store) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UITransferRecord loadValue(final RCTransferRecordProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UITransferRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCTransferRecordProxy createValue(final UITransferRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy getCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCTransferRecordProxy record) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
