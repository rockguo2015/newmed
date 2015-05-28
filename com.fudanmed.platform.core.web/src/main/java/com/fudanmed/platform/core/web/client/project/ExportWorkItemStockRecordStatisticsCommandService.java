package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordStatisticsCommandService")
public interface ExportWorkItemStockRecordStatisticsCommandService extends RemoteService {
  public abstract String prepareExport(final UIWorkItemStockStatisticsCriteria pagedCriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
