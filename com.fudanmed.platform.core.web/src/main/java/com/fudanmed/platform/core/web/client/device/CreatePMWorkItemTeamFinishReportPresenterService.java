package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemTeamFinishReportData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportPresenterService")
public interface CreatePMWorkItemTeamFinishReportPresenterService extends RemoteService {
  public abstract void updateValue(final RCPMWorkItemProxy workItem, final UIPMWorkItemTeamFinishReportData uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
