package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemManagementView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = PMWorkItemManagementView.class)
public interface PMWorkItemManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIPMWorkItem> results);
  
  public abstract void refresh();
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIPMWorkItemCriteria> requestHandler);
  
  public abstract void pmworkitemSelected(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void selectedPlansRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void finishWorkItemRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void setWorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter);
  
  public abstract void setWorkItemWorkerAssignmentListPresenter(final PMWorkItemWorkerAssignmentListPresenter workItemWorkerAssignmentListPresenter);
  
  public abstract void setWorkItemEvaluatePropertyViewPresenter(final PMWorkItemEvaluatePropertyViewPresenter workItemEvaluatePropertyViewPresenter);
  
  public abstract void setWorkItemPropertyPresenter(final PMWorkItemPropertyPresenter workItemPropertyPresenter);
}
