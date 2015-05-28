package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterService")
public interface PMWorkItemEvaluatePropertyViewPresenterService extends RemoteService {
  public abstract UIPMWorkItemEvaluate loadValue(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
