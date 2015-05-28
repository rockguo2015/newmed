package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllDeliverOrganizationContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<DLDeliverOrganizationProxy>> callback);
}
