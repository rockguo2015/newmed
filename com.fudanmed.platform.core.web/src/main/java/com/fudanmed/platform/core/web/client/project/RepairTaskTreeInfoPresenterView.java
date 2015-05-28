package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.project.ComplaintListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoView;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = RepairTaskTreeInfoView.class)
public interface RepairTaskTreeInfoPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIGeneralTask> results);
  
  public abstract void showComment(final String comment);
  
  public abstract void showCommentRequest(final RequestHandler1<UIGeneralTask> requestHandler);
  
  public abstract void setRepairTaskDetailInfoPresenter(final RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter);
  
  public abstract void setWorkItemStorageListPresenter(final WorkItemStorageListPresenter workItemStorageListPresenter);
  
  public abstract void setShowRepairEvaluatePresenter(final ShowRepairEvaluatePresenter showRepairEvaluatePresenter);
  
  public abstract void setComplaintListPresenter(final ComplaintListPresenter complaintListPresenter);
  
  public abstract void setWorkitemPictureListPresenter(final PictureListPresenter workitemPictureListPresenter);
}
