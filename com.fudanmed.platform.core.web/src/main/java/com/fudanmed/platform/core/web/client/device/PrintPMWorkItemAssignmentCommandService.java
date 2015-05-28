package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PrintPMWorkItemAssignmentCommandService")
public interface PrintPMWorkItemAssignmentCommandService extends RemoteService {
  public abstract String generatePrintContents(final RCPMWorkItemWorkerAssignmentProxy workItemTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
