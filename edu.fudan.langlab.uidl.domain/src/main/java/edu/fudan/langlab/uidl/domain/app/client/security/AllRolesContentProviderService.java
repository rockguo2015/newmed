package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.AllRolesContentProviderService")
public interface AllRolesContentProviderService extends RemoteService {
  public abstract Collection<RoleProxy> load();
}
