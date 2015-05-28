package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenterService")
public interface ProductSummarySnapshotQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UIProductSummarySnapshotStatCriteriaData> filter(final UIProductSummarySnapshotCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
