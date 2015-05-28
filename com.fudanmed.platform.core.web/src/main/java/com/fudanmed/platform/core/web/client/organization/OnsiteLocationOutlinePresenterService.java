package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenterService")
public interface OnsiteLocationOutlinePresenterService extends RemoteService {
  public abstract Collection<UIOnsitePosition> loadAllOnsitePosition() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIOnsitePosition getValue(final RCOnsitePositionProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
