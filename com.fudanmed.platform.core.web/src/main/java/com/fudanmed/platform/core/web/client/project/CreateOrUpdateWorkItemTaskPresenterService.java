package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenterService")
public interface CreateOrUpdateWorkItemTaskPresenterService extends RemoteService {
  public abstract UIWorkItemTask loadValue(final RCWorkItemTaskProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIWorkItemTask uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCWorkItemTaskProxy createValue(final RCGroupTaskProxy groupTask, final UIWorkItemTask uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOrganizationProxy loadTeam(final RCGroupTaskProxy groupTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy loadSystemUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIRepairTask loadRepairTask(final RCGroupTaskProxy groupTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCWorkItemTaskProxy workItemTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
