package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateWorkItemTaskPresenterServiceAsync {
  public abstract void loadValue(final RCWorkItemTaskProxy pvalue, final AsyncCallback<UIWorkItemTask> callback);
  
  public abstract void updateValue(final UIWorkItemTask uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final RCGroupTaskProxy groupTask, final UIWorkItemTask uivalue, final AsyncCallback<RCWorkItemTaskProxy> callback);
  
  public abstract void loadTeam(final RCGroupTaskProxy groupTask, final AsyncCallback<RCOrganizationProxy> callback);
  
  public abstract void loadSystemUser(final AsyncCallback<RCEmployeeProxy> callback);
  
  public abstract void loadRepairTask(final RCGroupTaskProxy groupTask, final AsyncCallback<UIRepairTask> callback);
  
  public abstract void generatePrintContents(final RCWorkItemTaskProxy workItemTask, final AsyncCallback<String> callback);
}
