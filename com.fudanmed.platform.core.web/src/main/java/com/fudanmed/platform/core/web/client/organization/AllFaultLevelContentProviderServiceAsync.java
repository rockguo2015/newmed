package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllFaultLevelContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCFaultLevelProxy>> callback);
}
