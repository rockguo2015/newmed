package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = PMTeamWorkItemManagementView.class)
public interface PMTeamWorkItemManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIPMWorkItem> results);
  
  public abstract void refresh();
  
  public abstract void assignWorkerRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIPMWorkItemCriteria> requestHandler);
  
  public abstract void pmworkitemSelected(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void reportFinishRequest(final RequestHandler1<RCPMWorkItemWorkerAssignmentProxy> requestHandler);
  
  public abstract void reportAllFinishRequest(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void pendRequest(final RequestHandler1<RCPMWorkItemWorkerAssignmentProxy> requestHandler);
  
  public abstract void setWorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter);
  
  public abstract void setWorkItemWorkerAssignmentListPresenter(final PMWorkItemWorkerAssignmentListPresenter workItemWorkerAssignmentListPresenter);
  
  public abstract void setWorkItemEvaluatePropertyViewPresenter(final PMWorkItemEvaluatePropertyViewPresenter workItemEvaluatePropertyViewPresenter);
  
  public abstract void setWorkItemPropertyPresenter(final PMWorkItemPropertyPresenter workItemPropertyPresenter);
}
