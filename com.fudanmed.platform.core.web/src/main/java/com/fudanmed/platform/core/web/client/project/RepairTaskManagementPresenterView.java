package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementView;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = RepairTaskManagementView.class)
public interface RepairTaskManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIRepairTask> results);
  
  public abstract void refresh();
  
  public abstract void refreshNew(final RCRepairTaskProxy value);
  
  public abstract void markAsDirty();
  
  public abstract void resetDirty();
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void cancelRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIRepairTaskCriteria> requestHandler);
  
  public abstract void dispatchRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void closeRepairTaskRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void showRepairTaskDetailRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void setRepairTaskInfoPresenter(final RepairTaskTreeInfoPresenter repairTaskInfoPresenter);
}
