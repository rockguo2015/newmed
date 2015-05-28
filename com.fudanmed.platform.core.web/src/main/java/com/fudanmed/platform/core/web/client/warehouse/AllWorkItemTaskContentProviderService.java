package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllWorkItemTaskContentProviderService")
public interface AllWorkItemTaskContentProviderService extends RemoteService {
  public abstract Collection<RCWorkItemTaskProxy> load();
}
