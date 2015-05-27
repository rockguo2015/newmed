package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;

public interface CreateOrUpdateAppFunctionAssignmentPresenterServiceAsync {
  public abstract void loadValue(final String roleId, final AsyncCallback<UIAppFunctionAssignment> callback);
  
  public abstract void updateValue(final UIAppFunctionAssignment uivalue, final AsyncCallback<Void> callback);
}
