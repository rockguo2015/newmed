package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RepairTaskTreeInfoPresenterServiceAsync {
  public abstract void loadTree(final RCRepairTaskProxy value, final AsyncCallback<Collection<UIGeneralTask>> callback);
  
  public abstract void loadComment(final UIGeneralTask generalTask, final AsyncCallback<String> callback);
}
