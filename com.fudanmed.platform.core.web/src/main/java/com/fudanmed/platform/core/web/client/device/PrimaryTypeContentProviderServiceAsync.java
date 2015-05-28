package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PrimaryTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCPrimaryTypeProxy>> callback);
}
