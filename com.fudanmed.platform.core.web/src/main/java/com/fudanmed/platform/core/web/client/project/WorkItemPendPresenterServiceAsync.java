package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemPendData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkItemPendPresenterServiceAsync {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemPendData data, final AsyncCallback<Void> callback);
  
  public abstract void getComment(final RCWorkItemTaskProxy context, final AsyncCallback<String> callback);
}
