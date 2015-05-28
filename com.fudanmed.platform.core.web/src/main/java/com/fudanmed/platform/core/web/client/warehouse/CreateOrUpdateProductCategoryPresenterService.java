package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryPresenterService")
public interface CreateOrUpdateProductCategoryPresenterService extends RemoteService {
  public abstract UIProductCategory loadValue(final RCProductCategoryProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIProductCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCProductCategoryProxy createValue(final UIProductCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
