package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourcePresenterService")
public interface RepairTaskStatByReportSourcePresenterService extends RemoteService {
  public abstract Collection<UIRepairTaskStatByReportSourceCriteriaData> loadResult(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
