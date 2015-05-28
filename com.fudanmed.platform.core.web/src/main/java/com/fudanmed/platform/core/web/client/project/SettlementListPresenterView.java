package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.SettlementListView;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = SettlementListView.class)
public interface SettlementListPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UISettlement> results);
  
  public abstract void showDetails(final Collection<UIRepairTask> details);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UISettlementCriteria> requestHandler);
  
  public abstract void showDetailRequest(final RequestHandler1<RCSettlementProxy> requestHandler);
  
  public abstract void createSettlementRequest(final RequestHandler requestHandler);
  
  public abstract void modifySettlementRequest(final RequestHandler1<RCSettlementProxy> requestHandler);
  
  public abstract void cancelSettlementRequest(final RequestHandler1<RCSettlementProxy> requestHandler);
  
  public abstract void addRepairTaskItemsRequest(final RequestHandler1<RCSettlementProxy> requestHandler);
  
  public abstract void cancelSettlementItemRequest(final RequestHandler1<Collection<RCRepairTaskProxy>> requestHandler);
  
  public abstract void showRepairTaskDetail(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void printSettlementRequest(final RequestHandler1<RCSettlementProxy> requestHandler);
  
  public abstract void setWorkItemStorage4SettlementListPresenter(final WorkItemStorage4SettlementListPresenter workItemStorage4SettlementListPresenter);
}
