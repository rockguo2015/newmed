package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenterService")
public interface FinishWorkItemPlanAssignmentPresenterService extends RemoteService {
  public abstract void createValue(final UIWorkItemPlanAssignmentFinishData uivalue, final Collection<RCWorkItemPlanAssignmentProxy> parents) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
