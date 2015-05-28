package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.proxy.UserProxy;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenterService")
public interface ResetPasswdPresenterService extends RemoteService {
  public abstract String getUserId(final UserProxy user) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void changePasswd(final UIResetPasswdData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
