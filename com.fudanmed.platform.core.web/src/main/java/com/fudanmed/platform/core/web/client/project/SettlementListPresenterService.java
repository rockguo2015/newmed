package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.SettlementListPresenterService")
public interface SettlementListPresenterService extends RemoteService {
  public abstract IPagedResult<UISettlement> filter(final UISettlementCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCSettlementProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIRepairTask> loadDetails(final RCSettlementProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void cancelSettlementItems(final Collection<RCRepairTaskProxy> repairTasks) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String generatePrintContents(final RCSettlementProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String prepareExport(final RCSettlementProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
