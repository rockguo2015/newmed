package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenterService")
public interface WorkItemStorage4SettlementListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemStorage4Settlement> loadWorkItemStorageList4Settlement(final RCSettlementProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String prepareExport(final RCSettlementProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
