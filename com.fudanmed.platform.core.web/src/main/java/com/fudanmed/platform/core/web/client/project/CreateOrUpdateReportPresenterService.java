package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenterService")
public interface CreateOrUpdateReportPresenterService extends RemoteService {
  public abstract UIRepairTask loadValue(final RCRepairTaskProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIRepairTask uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIFaultType> loadFaultTypes(final String name) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract OrgRelatedInfoData loadOrgRelatedInfoData(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String getFullPath(final RCOnsitePositionProxy loc) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract OrgRelatedInfoData loadOrgRelatedInfoData4Task(final RCRepairTaskProxy uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCOrganizationProxy getReportOrg() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIEmployee getReporter() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<String> getLastReportContents() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
