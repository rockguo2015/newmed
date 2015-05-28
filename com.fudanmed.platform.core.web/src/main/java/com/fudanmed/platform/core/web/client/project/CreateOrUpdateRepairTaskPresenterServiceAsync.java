package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateRepairTaskPresenterServiceAsync {
  public abstract void loadValue(final RCRepairTaskProxy pvalue, final AsyncCallback<UIRepairTask> callback);
  
  public abstract void updateValue(final UIRepairTask uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIRepairTask uivalue, final AsyncCallback<RCRepairTaskProxy> callback);
  
  public abstract void loadOrgRelatedInfoData(final RCOrganizationProxy org, final AsyncCallback<OrgRelatedInfoData> callback);
  
  public abstract void loadOrgRelatedInfoData4Task(final RCRepairTaskProxy uivalue, final AsyncCallback<OrgRelatedInfoData> callback);
  
  public abstract void getFullPath(final RCOnsitePositionProxy loc, final AsyncCallback<String> callback);
  
  public abstract void getSystemUser(final AsyncCallback<RCEmployeeProxy> callback);
}
