package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenterService")
public interface GroupTaskManagementPresenterService extends RemoteService {
  public abstract String getTeamName() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Boolean isDirty() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract IPagedResult<UIGroupTask> filter(final UIGroupTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCGroupTaskProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCRepairTaskProxy getRepairTask(final RCGroupTaskProxy groupTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCWorkItemTaskProxy workItemTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
