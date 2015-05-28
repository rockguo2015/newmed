package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.app.client.login.LoginSuccessHandler;

public class LoginSuccessEvent extends GwtEvent<LoginSuccessHandler> {
  public static Type<LoginSuccessHandler> __type__ = new Type<LoginSuccessHandler>();
  
  public Type<LoginSuccessHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final LoginSuccessHandler handler) {
    handler.LoginSuccess();
  }
  
  public LoginSuccessEvent() {
    
  }
}
