package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationPresenterService")
public interface CreateOrUpdateCheckOrganizationPresenterService extends RemoteService {
  public abstract UICheckOrganization loadValue(final DLCheckOrganizationProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UICheckOrganization uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UICheckOrganization uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
