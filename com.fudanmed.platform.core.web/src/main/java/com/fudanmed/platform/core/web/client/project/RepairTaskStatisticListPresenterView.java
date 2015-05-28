package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = RepairTaskStatisticListView.class)
public interface RepairTaskStatisticListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIRepairTaskStatisticData> results);
  
  public abstract void setSelectedOrganization(final RCOrganizationProxy newOrg);
  
  public abstract void refresh();
  
  public abstract void queryRequest(final RequestHandler1<UIRepairTaskStatisticCriteria> requestHandler);
  
  public abstract void teamChanged(final RequestHandler1<RCMaintenanceTeamProxy> requestHandler);
}
