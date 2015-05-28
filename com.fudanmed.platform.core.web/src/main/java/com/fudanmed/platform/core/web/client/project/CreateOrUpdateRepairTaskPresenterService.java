package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenterService")
public interface CreateOrUpdateRepairTaskPresenterService extends RemoteService {
  public abstract UIRepairTask loadValue(final RCRepairTaskProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCRepairTaskProxy createValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract OrgRelatedInfoData loadOrgRelatedInfoData(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract OrgRelatedInfoData loadOrgRelatedInfoData4Task(final RCRepairTaskProxy uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String getFullPath(final RCOnsitePositionProxy loc) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCEmployeeProxy getSystemUser() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
