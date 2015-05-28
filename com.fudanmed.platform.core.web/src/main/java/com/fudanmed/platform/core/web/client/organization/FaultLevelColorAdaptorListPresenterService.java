package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorListPresenterService")
public interface FaultLevelColorAdaptorListPresenterService extends RemoteService {
  public abstract Collection<UIFaultLevelColorAdaptor> loadFaultLevelColorAdaptorList() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
