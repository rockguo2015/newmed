package com.lanmon.business.client.customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.lanmon.business.shared.customer.CustomerContentProviderCriteria;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.lanmon.business.client.customer.CustomerContentProviderService")
public interface CustomerContentProviderService extends RemoteService {
  public abstract Collection<GWTNamedEntity> load(final CustomerContentProviderCriteria criteria);
}
