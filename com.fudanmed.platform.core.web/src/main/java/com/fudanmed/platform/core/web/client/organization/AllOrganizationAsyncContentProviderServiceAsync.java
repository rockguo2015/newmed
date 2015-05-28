package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.AllOrganizationAsyncContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllOrganizationAsyncContentProviderServiceAsync {
  public abstract void load(final AllOrganizationAsyncContentProviderCriteria criteria, final AsyncCallback<Collection<RCOrganizationProxy>> callback);
}
