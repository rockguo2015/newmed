package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllEmployeesContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCEmployeeProxy>> callback);
}
