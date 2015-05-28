package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface GroupTaskManagementPresenterServiceAsync {
  public abstract void getTeamName(final AsyncCallback<String> callback);
  
  public abstract void isDirty(final AsyncCallback<Boolean> callback);
  
  public abstract void filter(final UIGroupTaskCriteria uicriteria, final AsyncCallback<IPagedResult<UIGroupTask>> callback);
  
  public abstract void delete(final RCGroupTaskProxy value, final AsyncCallback<Void> callback);
  
  public abstract void getRepairTask(final RCGroupTaskProxy groupTask, final AsyncCallback<RCRepairTaskProxy> callback);
  
  public abstract void generatePrintContents(final RCWorkItemTaskProxy workItemTask, final AsyncCallback<String> callback);
}
