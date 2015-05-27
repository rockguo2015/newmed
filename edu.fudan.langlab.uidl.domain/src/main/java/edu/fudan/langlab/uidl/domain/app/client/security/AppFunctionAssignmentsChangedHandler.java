package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventHandler;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;

public interface AppFunctionAssignmentsChangedHandler extends EventHandler {
  public abstract void AppFunctionAssignmentsChanged(final UIAppRole role);
}
