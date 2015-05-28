package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllFaultTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCFaultTypeProxy>> callback);
}
