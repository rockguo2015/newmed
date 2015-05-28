package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryPresenterService")
public interface CreateOrUpdateDeliverMaterialCategoryPresenterService extends RemoteService {
  public abstract UIDeliverMaterialCategory loadValue(final DLDeliverMaterialCategoryProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIDeliverMaterialCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final DLDeliverMaterialCategoryProxy parent, final UIDeliverMaterialCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
