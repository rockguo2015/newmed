package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenterService")
public interface RoleManagementPresenterService extends RemoteService {
  public abstract Collection<UIRole> loadRoleList() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean canDelete(final RoleProxy role) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RoleProxy role) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
