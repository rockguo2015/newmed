package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.shared.login.UIUser;
import java.util.Collection;

public interface LoginPresenterServiceAsync {
  public abstract void isSuperUsr(final String userid, final AsyncCallback<Boolean> callback);
  
  public abstract void login(final String userid, final String passwd, final AsyncCallback<UIUser> callback);
  
  public abstract void loadFunctions4User(final UIUser user, final AsyncCallback<Collection<? extends IFunctionIdentifier>> callback);
}
