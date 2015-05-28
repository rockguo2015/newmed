package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.security.proxy.UserProxy;

public interface ResetPasswdPresenterServiceAsync {
  public abstract void getUserId(final UserProxy user, final AsyncCallback<String> callback);
  
  public abstract void changePasswd(final UIResetPasswdData data, final AsyncCallback<Void> callback);
}
