package com.lanmon.business.client.contact;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.lanmon.business.client.contact.ContactCodeProviderService")
public interface ContactCodeProviderService extends RemoteService {
  public abstract Collection<GWTNamedEntity> load();
}
