package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.AllFaultTypeContentProviderService")
public interface AllFaultTypeContentProviderService extends RemoteService {
  public abstract Collection<RCFaultTypeProxy> load();
}
