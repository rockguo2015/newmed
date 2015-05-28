package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierPresenterService")
public interface CreateOrUpdateSupplierPresenterService extends RemoteService {
  public abstract UISupplier loadValue(final RCSupplierProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UISupplier uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCSupplierProxy createValue(final UISupplier uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
