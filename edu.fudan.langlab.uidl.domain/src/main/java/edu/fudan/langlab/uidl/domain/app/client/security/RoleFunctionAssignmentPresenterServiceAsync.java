package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Collection;

public interface RoleFunctionAssignmentPresenterServiceAsync {
  public abstract void getAllRoles(final AsyncCallback<Collection<UIAppRole>> callback);
  
  public abstract void getFunctions4Role(final String roleId, final AsyncCallback<Collection<UIAppFunction>> callback);
}
