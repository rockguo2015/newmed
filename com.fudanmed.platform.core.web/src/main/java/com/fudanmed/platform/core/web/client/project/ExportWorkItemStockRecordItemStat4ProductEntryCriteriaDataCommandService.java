package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandService")
public interface ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandService extends RemoteService {
  public abstract String prepareExport(final UIWorkItemStockRecordItemStatCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
