package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenterService")
public interface WorkItemStockStatisticListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemStockRecordStatisticsData> loadRepairTaskList(final UIWorkItemStockStatisticsCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
