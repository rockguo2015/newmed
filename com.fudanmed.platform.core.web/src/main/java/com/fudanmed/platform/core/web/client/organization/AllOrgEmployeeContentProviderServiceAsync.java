package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.organization.AllOrgEmployeeContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllOrgEmployeeContentProviderServiceAsync {
  public abstract void load(final AllOrgEmployeeContentProviderCriteria criteria, final AsyncCallback<Collection<RCEmployeeProxy>> callback);
}
