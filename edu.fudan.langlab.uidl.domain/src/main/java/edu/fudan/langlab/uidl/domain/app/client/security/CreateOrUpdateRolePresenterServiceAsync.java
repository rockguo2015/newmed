package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;

public interface CreateOrUpdateRolePresenterServiceAsync {
  public abstract void loadValue(final RoleProxy pvalue, final AsyncCallback<UIRole> callback);
  
  public abstract void updateValue(final UIRole uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIRole uivalue, final AsyncCallback<Void> callback);
}
