package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenterService")
public interface WorkItemStockRecordItemStat4ProductEntryListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> load(final UIWorkItemStockRecordItemStatCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
