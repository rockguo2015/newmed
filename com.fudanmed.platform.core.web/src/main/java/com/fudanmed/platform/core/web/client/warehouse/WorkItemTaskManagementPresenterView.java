package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemTaskManagementView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemTaskCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = WorkItemTaskManagementView.class)
public interface WorkItemTaskManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIWorkItemTask> results);
  
  public abstract void refresh();
  
  public abstract void refreshChild();
  
  public abstract void showWorkItemOutStockRecordDetail(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler);
  
  public abstract void print(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler);
  
  public abstract void printFit(final RequestHandler1<RCWorkItemStockRecordProxy> requestHandler);
  
  public abstract void createWorkItemOutStoreRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void createWorkItemReturnStoreRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIWorkItemTaskCriteria> requestHandler);
  
  public abstract void showWorkItemDetailRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void setWorkItemOutStockRecordListPresenter(final WorkItemOutStockRecordListPresenter workItemOutStockRecordListPresenter);
  
  public abstract void setWorkItemStorageListPresenter(final WorkItemStorageListPresenter workItemStorageListPresenter);
}
