package com.lanmon.business.client.customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.lanmon.business.client.customer.DomainCodeProviderService")
public interface DomainCodeProviderService extends RemoteService {
  public abstract Collection<GWTNamedEntity> load();
}
