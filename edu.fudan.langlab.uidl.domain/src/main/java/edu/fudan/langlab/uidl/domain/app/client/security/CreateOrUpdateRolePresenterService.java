package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRolePresenterService")
public interface CreateOrUpdateRolePresenterService extends RemoteService {
  public abstract UIRole loadValue(final RoleProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIRole uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIRole uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
