package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface WorkItemTaskManagementPresenterServiceAsync {
  public abstract void generatePrintContents(final RCWorkItemStockRecordProxy record, final AsyncCallback<String> callback);
  
  public abstract void generateOutFitPrintContents(final RCWorkItemOutStockRecordProxy record, final AsyncCallback<String> callback);
  
  public abstract void filter(final UIWorkItemTaskCriteria uicriteria, final AsyncCallback<IPagedResult<UIWorkItemTask>> callback);
  
  public abstract void delete(final RCWorkItemTaskProxy value, final AsyncCallback<Void> callback);
  
  public abstract void isOutStock(final RCWorkItemStockRecordProxy context, final AsyncCallback<Boolean> callback);
}
