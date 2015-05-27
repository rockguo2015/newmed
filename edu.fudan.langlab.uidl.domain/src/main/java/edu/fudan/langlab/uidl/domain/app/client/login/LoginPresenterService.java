package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.security.shared.IFunctionIdentifier;
import edu.fudan.langlab.uidl.domain.app.shared.login.UIUser;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.login.LoginPresenterService")
public interface LoginPresenterService extends RemoteService {
  public abstract Boolean isSuperUsr(final String userid) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIUser login(final String userid, final String passwd) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<? extends IFunctionIdentifier> loadFunctions4User(final UIUser user) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
