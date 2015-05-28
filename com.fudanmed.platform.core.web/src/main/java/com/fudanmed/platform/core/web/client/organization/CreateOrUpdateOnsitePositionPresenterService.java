package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionPresenterService")
public interface CreateOrUpdateOnsitePositionPresenterService extends RemoteService {
  public abstract UIOnsitePosition loadValue(final RCOnsitePositionProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIOnsitePosition uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOnsitePositionProxy createValue(final UIOnsitePosition uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
