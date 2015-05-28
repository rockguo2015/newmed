package com.fudanmed.platform.core.web.client.common;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Date;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.common.ServerSideTimeService")
public interface ServerSideTimeService extends RemoteService {
  public abstract Date getTime() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
