package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemFinishReportData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkItemFinishReportPresenterServiceAsync {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemFinishReportData data, final AsyncCallback<Void> callback);
  
  public abstract void getComment(final RCWorkItemTaskProxy context, final AsyncCallback<String> callback);
  
  public abstract void getCanReport(final RCWorkItemTaskProxy context, final AsyncCallback<Boolean> callback);
}
