package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemCancelPendData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemCancelPendPresenterService")
public interface WorkItemCancelPendPresenterService extends RemoteService {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemCancelPendData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String getComment(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean canReport(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
