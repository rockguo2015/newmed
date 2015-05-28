package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.FaultReportSourceContentProviderService")
public interface FaultReportSourceContentProviderService extends RemoteService {
  public abstract Collection<RCFaultReportSourceProxy> load();
}
