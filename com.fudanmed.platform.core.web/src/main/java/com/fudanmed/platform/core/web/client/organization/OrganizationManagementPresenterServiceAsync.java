package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OrganizationManagementPresenterServiceAsync {
  public abstract void delete(final RCOrganizationProxy value, final AsyncCallback<Void> callback);
}
