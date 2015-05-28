package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummaryCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummaryManagementPresenterService")
public interface ProductWarehouseStorageSummaryManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIProductWarehouseStorageSummary> filter(final UIProductWarehouseStorageSummaryCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCProductWarehouseStorageSummaryProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCProductSpecificationProxy getProductSpec(final RCProductWarehouseStorageSummaryProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy loadCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
