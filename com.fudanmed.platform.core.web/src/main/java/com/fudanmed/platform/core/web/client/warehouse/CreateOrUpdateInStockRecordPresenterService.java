package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCInStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.shared.warehouse.CreateOrUpdateInStockRecordInitData;
import com.fudanmed.platform.core.web.shared.warehouse.UIInStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateInStockRecordPresenterService")
public interface CreateOrUpdateInStockRecordPresenterService extends RemoteService {
  public abstract UIInStockRecord loadValue(final RCInStockRecordProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCInStockRecordProxy updateValue(final UIInStockRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIProductSpecification getProductSpecByProductSid(final String productSid) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCInStockRecordProxy createValue(final UIInStockRecord uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract CreateOrUpdateInStockRecordInitData loadCreateOrUpdateInStockRecordInitData() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy loadStoreManager(final RCWarehouseProxy store) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContent(final RCInStockRecordProxy inStockRecord) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
