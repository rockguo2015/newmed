package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthPresenterService")
public interface RepairTaskStatByMonthPresenterService extends RemoteService {
  public abstract Collection<UIRepairTaskStatByMonthCriteriaData> loadResult(final UIRepairTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
