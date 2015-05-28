package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyPresenterService")
public interface WorkItemPlanAssignmentPropertyPresenterService extends RemoteService {
  public abstract UIWorkItemPlanAssignment loadValue(final RCWorkItemPlanAssignmentProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
