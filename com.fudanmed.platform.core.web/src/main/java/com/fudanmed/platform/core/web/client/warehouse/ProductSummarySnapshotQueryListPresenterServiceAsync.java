package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface ProductSummarySnapshotQueryListPresenterServiceAsync {
  public abstract void filter(final UIProductSummarySnapshotCriteria uicriteria, final AsyncCallback<IPagedResult<UIProductSummarySnapshotStatCriteriaData>> callback);
}
