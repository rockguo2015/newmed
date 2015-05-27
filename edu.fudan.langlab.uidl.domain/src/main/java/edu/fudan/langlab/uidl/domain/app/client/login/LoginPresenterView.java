package edu.fudan.langlab.uidl.domain.app.client.login;

import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.Viewer;

public interface LoginPresenterView extends Viewer {
  public abstract void login(final RequestHandler2<String,String> requestHandler);
  
  public abstract void loginFailed();
}
