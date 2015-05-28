package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.ReportManagementView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = ReportManagementView.class)
public interface ReportManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIRepairTask> results);
  
  public abstract void refresh();
  
  public abstract void markAsDirty();
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void complaintRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void doEvaluate(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIReportCriteria> requestHandler);
  
  public abstract void showRepairTaskDetailRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void setRepairTaskInfoPresenter(final RepairTaskTreeInfoPresenter repairTaskInfoPresenter);
}
