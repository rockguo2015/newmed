package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryPresenterService")
public interface CreateOrUpdateDeliverPatientCheckCategoryPresenterService extends RemoteService {
  public abstract UIDeliverPatientCheckCategory loadValue(final DLDeliverPatientCheckCategoryProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIDeliverPatientCheckCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final DLDeliverPatientCheckCategoryProxy parent, final UIDeliverPatientCheckCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
