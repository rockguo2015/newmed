package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportView;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Collection;

@ImplementedBy(value = CreateOrUpdateReportView.class)
public interface CreateOrUpdateReportPresenterView extends ViewerWithValidation {
  public abstract UIRepairTask getValue();
  
  public abstract void setValue(final UIRepairTask value);
  
  public abstract void showHistoryReportContents(final Collection<String> reportContents);
  
  public abstract void locationSelected(final RequestHandler1<RCOnsitePositionProxy> requestHandler);
  
  public abstract void showOrgRelatedInfo(final Collection<UIOnsitePosition> pos, final Collection<UIEmployee> workers, final Collection<UIRepairTask> historyTasks);
  
  public abstract void setLocation(final String loc);
  
  public abstract void setDefaultReporter(final UIEmployee reporter);
  
  public abstract void setReportOrg(final RCOrganizationProxy organization);
}
