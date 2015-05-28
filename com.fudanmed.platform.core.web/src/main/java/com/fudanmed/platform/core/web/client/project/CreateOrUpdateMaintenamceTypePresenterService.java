package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIMaintenamceType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.CreateOrUpdateMaintenamceTypePresenterService")
public interface CreateOrUpdateMaintenamceTypePresenterService extends RemoteService {
  public abstract UIMaintenamceType loadValue(final RCMaintenamceTypeProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIMaintenamceType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCMaintenamceTypeProxy createValue(final UIMaintenamceType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
