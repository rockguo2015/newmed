package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllFaultEmergencyLevelContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCFaultEmergencyLevelProxy>> callback);
}
