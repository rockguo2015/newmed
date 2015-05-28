package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CheckOrganizationContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLCheckOrganizationProxy>> callback);
}
