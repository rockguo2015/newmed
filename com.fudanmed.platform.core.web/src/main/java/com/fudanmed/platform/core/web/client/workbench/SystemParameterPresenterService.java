package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenterService")
public interface SystemParameterPresenterService extends RemoteService {
  public abstract UISystemParameter loadParameter() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
