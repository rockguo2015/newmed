package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.ReportManagementPresenterService")
public interface ReportManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIRepairTask> filter(final UIReportCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void close(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCRepairEvaluateProxy loadRepairEvaluate(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
