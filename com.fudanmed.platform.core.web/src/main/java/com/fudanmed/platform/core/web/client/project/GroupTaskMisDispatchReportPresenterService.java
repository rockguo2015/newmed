package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.shared.project.GroupTaskMisDispatchReportData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportPresenterService")
public interface GroupTaskMisDispatchReportPresenterService extends RemoteService {
  public abstract void commit(final RCGroupTaskProxy context, final GroupTaskMisDispatchReportData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
