package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenterService")
public interface CreateOrUpdateFaultLevelColorAdaptorPresenterService extends RemoteService {
  public abstract UIFaultLevelColorAdaptor loadValue(final RCFaultLevelColorAdaptorProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIFaultLevelColorAdaptor uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
