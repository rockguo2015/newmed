package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllWorkTypeContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCWorkTypeProxy>> callback);
}
