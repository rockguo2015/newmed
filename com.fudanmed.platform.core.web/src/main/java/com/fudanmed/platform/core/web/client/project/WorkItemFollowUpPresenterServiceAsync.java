package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemFollowUpData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkItemFollowUpPresenterServiceAsync {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemFollowUpData data, final AsyncCallback<Void> callback);
  
  public abstract void getComment(final RCWorkItemTaskProxy context, final AsyncCallback<String> callback);
}
