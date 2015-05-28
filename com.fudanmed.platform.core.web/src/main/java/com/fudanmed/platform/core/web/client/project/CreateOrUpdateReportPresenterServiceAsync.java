package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CreateOrUpdateReportPresenterServiceAsync {
  public abstract void loadValue(final RCRepairTaskProxy pvalue, final AsyncCallback<UIRepairTask> callback);
  
  public abstract void updateValue(final UIRepairTask uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIRepairTask uivalue, final AsyncCallback<Void> callback);
  
  public abstract void loadFaultTypes(final String name, final AsyncCallback<Collection<UIFaultType>> callback);
  
  public abstract void loadOrgRelatedInfoData(final RCOrganizationProxy org, final AsyncCallback<OrgRelatedInfoData> callback);
  
  public abstract void getFullPath(final RCOnsitePositionProxy loc, final AsyncCallback<String> callback);
  
  public abstract void loadOrgRelatedInfoData4Task(final RCRepairTaskProxy uivalue, final AsyncCallback<OrgRelatedInfoData> callback);
  
  public abstract void getReportOrg(final AsyncCallback<RCOrganizationProxy> callback);
  
  public abstract void getReporter(final AsyncCallback<UIEmployee> callback);
  
  public abstract void getLastReportContents(final AsyncCallback<Collection<String>> callback);
}
