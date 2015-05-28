package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllOrganizationContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCOrganizationProxy>> callback);
}
