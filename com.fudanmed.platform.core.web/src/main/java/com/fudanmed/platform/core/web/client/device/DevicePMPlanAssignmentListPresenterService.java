package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenterService")
public interface DevicePMPlanAssignmentListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemPlanAssignment> loadDevicePlanAssignmentList(final RCDeviceProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
