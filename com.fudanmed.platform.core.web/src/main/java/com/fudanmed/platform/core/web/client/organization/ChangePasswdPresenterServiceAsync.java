package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.security.proxy.UserProxy;

public interface ChangePasswdPresenterServiceAsync {
  public abstract void changePasswd(final UIChangePasswdData data, final AsyncCallback<Void> callback);
  
  public abstract void getCurrentUser(final AsyncCallback<UserProxy> callback);
}
