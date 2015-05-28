package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.ProductCategoryManagementPresenterService")
public interface ProductCategoryManagementPresenterService extends RemoteService {
  public abstract Collection<UIProductCategory> loadAllProductCategory() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCProductCategoryProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIProductCategory getValue(final RCProductCategoryProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIProductType> loadItems(final RCProductCategoryProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void deleteChild(final RCProductTypeProxy child) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
