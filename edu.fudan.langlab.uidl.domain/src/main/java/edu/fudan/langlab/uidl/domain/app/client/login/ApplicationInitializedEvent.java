package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.app.client.login.ApplicationInitializedHandler;
import edu.fudan.langlab.uidl.domain.app.client.workbench.ApplicationWorkbenchPresenter;

public class ApplicationInitializedEvent extends GwtEvent<ApplicationInitializedHandler> {
  public static Type<ApplicationInitializedHandler> __type__ = new Type<ApplicationInitializedHandler>();
  
  public Type<ApplicationInitializedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ApplicationInitializedHandler handler) {
    handler.ApplicationInitialized(app);
  }
  
  private ApplicationWorkbenchPresenter app;
  
  public ApplicationInitializedEvent(final ApplicationWorkbenchPresenter app) {
    this.app=app;
    
  }
}
