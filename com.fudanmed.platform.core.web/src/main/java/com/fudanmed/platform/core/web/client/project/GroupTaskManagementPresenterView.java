package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementView;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = GroupTaskManagementView.class)
public interface GroupTaskManagementPresenterView extends Viewer {
  public abstract ActionContext<UIGroupTask> getActionContext();
  
  public abstract void showResults(final IPagedResult<UIGroupTask> results);
  
  public abstract void refresh();
  
  public abstract void markAsDirty();
  
  public abstract void resetDirty();
  
  public abstract void setTeamName(final String name);
  
  public abstract void filterRequest(final RequestHandler1<UIGroupTaskCriteria> requestHandler);
  
  public abstract void showGroupTaskDetailRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler);
  
  public abstract void createWorkItemTaskRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler);
  
  public abstract void finishGroupTaskRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler);
  
  public abstract void misDispatchGroupTaskRequest(final RequestHandler1<RCGroupTaskProxy> requestHandler);
  
  public abstract void pendWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void cancelPendWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void outsourceWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void finishOutsourceWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void misDispatchingWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void finishWorkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void followUpWOrkItemTaskRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void printWorkItemRequest(final RequestHandler1<RCWorkItemTaskProxy> requestHandler);
  
  public abstract void setWorkItemTaskListPresenter(final WorkItemTaskListPresenter WorkItemTaskListPresenter);
  
  public abstract void setRepairTaskDetailInfoPresenter(final RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter);
  
  public abstract void setWorkItemStorageListPresenter(final WorkItemStorageListPresenter workItemStorageListPresenter);
  
  public abstract void setWorkitemPictureListPresenter(final PictureListPresenter workitemPictureListPresenter);
}
