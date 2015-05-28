package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterService")
public interface RepairTaskStatByOrganizationTypeListPresenterService extends RemoteService {
  public abstract Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> executeCriteria(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> load(final String month) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> load(final UIDateRange dateRange) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> load(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
