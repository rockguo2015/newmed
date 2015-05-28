package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.proxy.UserProxy;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenterService")
public interface ChangePasswdPresenterService extends RemoteService {
  public abstract void changePasswd(final UIChangePasswdData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UserProxy getCurrentUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
