package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.event.shared.EventHandler;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenter;

public interface ApplicationInitializedHandler extends EventHandler {
  public abstract void ApplicationInitialized(final ApplicationWorkbenchPresenter app);
}
