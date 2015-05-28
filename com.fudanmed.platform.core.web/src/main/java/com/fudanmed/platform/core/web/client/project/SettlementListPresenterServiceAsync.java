package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface SettlementListPresenterServiceAsync {
  public abstract void filter(final UISettlementCriteria uicriteria, final AsyncCallback<IPagedResult<UISettlement>> callback);
  
  public abstract void delete(final RCSettlementProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadDetails(final RCSettlementProxy parent, final AsyncCallback<Collection<UIRepairTask>> callback);
  
  public abstract void cancelSettlementItems(final Collection<RCRepairTaskProxy> repairTasks, final AsyncCallback<Void> callback);
  
  public abstract void generatePrintContents(final RCSettlementProxy value, final AsyncCallback<String> callback);
  
  public abstract void prepareExport(final RCSettlementProxy parent, final AsyncCallback<String> callback);
}
