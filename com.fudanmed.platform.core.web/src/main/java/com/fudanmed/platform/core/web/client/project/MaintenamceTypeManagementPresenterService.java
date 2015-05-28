package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.MaintenamceTypeManagementPresenterService")
public interface MaintenamceTypeManagementPresenterService extends RemoteService {
  public abstract Collection<UIMaintenamceType> loadAllMaintenamceType() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCMaintenamceTypeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIMaintenamceType getValue(final RCMaintenamceTypeProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIFaultType> loadItems(final RCMaintenamceTypeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void deleteChild(final RCFaultTypeProxy child) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
