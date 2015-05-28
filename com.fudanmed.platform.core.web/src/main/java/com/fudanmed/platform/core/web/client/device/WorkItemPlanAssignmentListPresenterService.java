package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterService")
public interface WorkItemPlanAssignmentListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemPlanAssignment> loadWorkItemPlanAssignmentList(final RCPMWorkItemProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIWorkItemPlanAssignment> loadUnassignedWorkItemPlanAssignmentList(final RCPMWorkItemProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIWorkItemPlanAssignment> loadWorkItemPlanAssignment4WorkerList(final RCPMWorkItemWorkerAssignmentProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
