package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import java.util.Collection;

public interface SelectRoles4UserPresenterServiceAsync {
  public abstract void loadRoles4User(final UserProxy user, final AsyncCallback<Collection<RoleProxy>> callback);
  
  public abstract void updateUserRoles(final UserProxy user, final UIUserRoles userRoles, final AsyncCallback<Void> callback);
}
