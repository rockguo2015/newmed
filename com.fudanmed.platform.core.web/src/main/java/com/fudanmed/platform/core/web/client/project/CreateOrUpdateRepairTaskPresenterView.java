package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskView;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import java.util.Collection;

@ImplementedBy(value = CreateOrUpdateRepairTaskView.class)
public interface CreateOrUpdateRepairTaskPresenterView extends FormViewer<UIRepairTask> {
  public abstract void organizationSelected(final RequestHandler1<RCOrganizationProxy> requestHandler);
  
  public abstract void locationSelected(final RequestHandler1<RCOnsitePositionProxy> requestHandler);
  
  public abstract void showOrgRelatedInfo(final Collection<UIOnsitePosition> pos, final Collection<UIEmployee> workers, final Collection<UIRepairTask> historyTasks);
  
  public abstract void setLocation(final String loc);
  
  public abstract void setDefaultValues(final RCEmployeeProxy operator);
  
  public abstract void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter);
}
