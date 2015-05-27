package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;

@RemoteServiceRelativePath("service/edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenterService")
public interface CreateOrUpdateAppFunctionAssignmentPresenterService extends RemoteService {
  public abstract UIAppFunctionAssignment loadValue(final String roleId) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIAppFunctionAssignment uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
