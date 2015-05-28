package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthView;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = RepairTaskStatByMonthView.class)
public interface RepairTaskStatByMonthPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIRepairTaskStatByMonthCriteriaData> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIRepairTaskCriteria> requestHandler);
  
  public abstract void setRepairTaskStatByFaultTypeListPresenter(final RepairTaskStatByFaultTypeListPresenter repairTaskStatByFaultTypeListPresenter);
  
  public abstract void setRepairTaskStatByOrganizationTypeListPresenter(final RepairTaskStatByOrganizationTypeListPresenter repairTaskStatByOrganizationTypeListPresenter);
  
  public abstract void setGroupTaskStatByTeamListPresenter(final GroupTaskStatByTeamListPresenter groupTaskStatByTeamListPresenter);
}
