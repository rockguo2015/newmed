package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemFinishOutsourceData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourcePresenterService")
public interface WorkItemFinishOutsourcePresenterService extends RemoteService {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemFinishOutsourceData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String loadComment(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean canReport(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
