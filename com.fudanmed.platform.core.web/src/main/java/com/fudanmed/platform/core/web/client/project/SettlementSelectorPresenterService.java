package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenterService")
public interface SettlementSelectorPresenterService extends RemoteService {
  public abstract IPagedResult<UIRepairTask> filter(final UIRepairTask4SettlementCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void performSettlement(final RCSettlementProxy settlement, final Collection<RCRepairTaskProxy> repairTasks) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UISettlement loadSettlement(final RCSettlementProxy settlement) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
