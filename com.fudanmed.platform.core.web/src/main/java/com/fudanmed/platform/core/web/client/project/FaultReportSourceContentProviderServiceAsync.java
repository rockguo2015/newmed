package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface FaultReportSourceContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCFaultReportSourceProxy>> callback);
}
