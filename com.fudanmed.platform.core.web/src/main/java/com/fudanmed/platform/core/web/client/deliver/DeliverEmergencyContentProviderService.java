package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.DeliverEmergencyContentProviderService")
public interface DeliverEmergencyContentProviderService extends RemoteService {
  public abstract Collection<DLDeliverEmergencyProxy> load();
}
