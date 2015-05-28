package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface SettlementSelectorPresenterServiceAsync {
  public abstract void filter(final UIRepairTask4SettlementCriteria uicriteria, final AsyncCallback<IPagedResult<UIRepairTask>> callback);
  
  public abstract void performSettlement(final RCSettlementProxy settlement, final Collection<RCRepairTaskProxy> repairTasks, final AsyncCallback<Void> callback);
  
  public abstract void loadSettlement(final RCSettlementProxy settlement, final AsyncCallback<UISettlement> callback);
}
