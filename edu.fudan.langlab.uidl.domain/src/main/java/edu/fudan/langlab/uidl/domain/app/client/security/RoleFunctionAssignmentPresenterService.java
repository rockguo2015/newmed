package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Collection;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenterService")
public interface RoleFunctionAssignmentPresenterService extends RemoteService {
  public abstract Collection<UIAppRole> getAllRoles() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIAppFunction> getFunctions4Role(final String roleId) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
