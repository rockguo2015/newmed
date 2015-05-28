package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllWorkItemTaskContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCWorkItemTaskProxy>> callback);
}
