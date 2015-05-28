package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenterService")
public interface WorkItemStorageListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemStorage> loadWorkItemStorageList4GroupTask(final RCGroupTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIWorkItemStorage> loadWorkItemStorageList4RepairTask(final RCRepairTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIWorkItemStorage> loadWorkItemStorageList4WorkItemTask(final RCWorkItemTaskProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
