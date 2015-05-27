package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenterService")
public interface SelectRoles4UserPresenterService extends RemoteService {
  public abstract Collection<RoleProxy> loadRoles4User(final UserProxy user) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateUserRoles(final UserProxy user, final UIUserRoles userRoles) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
