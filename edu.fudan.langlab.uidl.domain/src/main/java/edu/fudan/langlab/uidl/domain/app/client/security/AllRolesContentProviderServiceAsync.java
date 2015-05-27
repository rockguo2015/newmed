package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import java.util.Collection;

public interface AllRolesContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RoleProxy>> callback);
}
