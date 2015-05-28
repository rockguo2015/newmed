package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import java.util.Collection;

public interface RepairTaskStatByFaultTypeListPresenterServiceAsync {
  public abstract void executeCriteria(final UIRepairTaskCriteria uicriteria, final AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> callback);
  
  public abstract void load(final UIDateRange dateRange, final AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> callback);
  
  public abstract void load(final String month, final AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> callback);
  
  public abstract void load(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource, final AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> callback);
}
