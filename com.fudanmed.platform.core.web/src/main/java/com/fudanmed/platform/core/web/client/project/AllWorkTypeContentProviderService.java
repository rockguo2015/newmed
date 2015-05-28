package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.AllWorkTypeContentProviderService")
public interface AllWorkTypeContentProviderService extends RemoteService {
  public abstract Collection<RCWorkTypeProxy> load();
}
