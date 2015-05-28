package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.SettlementSelectorView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Collection;
import java.util.Date;

@ImplementedBy(value = SettlementSelectorView.class)
public interface SettlementSelectorPresenterView extends ViewerWithValidation {
  public abstract void showResults(final Collection<UIRepairTask> results);
  
  public abstract void refresh();
  
  public abstract void setInitialDateRange(final Date fromDate, final Date toDate);
  
  public abstract Iterable<UIRepairTask> getSelectedRepairTasks();
  
  public abstract void filterRequest(final RequestHandler1<UIRepairTask4SettlementCriteria> requestHandler);
  
  public abstract void showTaskDetailRequest(final RequestHandler1<RCRepairTaskProxy> requestHandler);
  
  public abstract void setRepairTaskInfoPresenter(final RepairTaskTreeInfoPresenter repairTaskInfoPresenter);
}
