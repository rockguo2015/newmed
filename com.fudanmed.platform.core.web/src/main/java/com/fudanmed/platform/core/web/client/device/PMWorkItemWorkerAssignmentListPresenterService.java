package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterService")
public interface PMWorkItemWorkerAssignmentListPresenterService extends RemoteService {
  public abstract Collection<UIPMWorkItemWorkerAssignment> loadPMWorkItemWorkerAssignmentList(final RCPMWorkItemProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
