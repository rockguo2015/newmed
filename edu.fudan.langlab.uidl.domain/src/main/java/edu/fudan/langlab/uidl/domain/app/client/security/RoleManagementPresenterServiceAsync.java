package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Collection;

public interface RoleManagementPresenterServiceAsync {
  public abstract void loadRoleList(final AsyncCallback<Collection<UIRole>> callback);
  
  public abstract void canDelete(final RoleProxy role, final AsyncCallback<Boolean> callback);
  
  public abstract void delete(final RoleProxy role, final AsyncCallback<Void> callback);
}
