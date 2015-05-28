package com.fudanmed.platform.core.web.client.workbench;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.workbench.RouterPresenterService")
public interface RouterPresenterService extends RemoteService {
  public abstract Boolean isReporter() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
