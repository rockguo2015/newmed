package com.fudanmed.platform.core.web.client.workbench;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.workbench.HeaderPresenterService")
public interface HeaderPresenterService extends RemoteService {
  public abstract String getAppTitle() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
