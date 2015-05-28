package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenterService")
public interface PMWorkItemManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIPMWorkItem> filter(final UIPMWorkItemCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void finishWorkItem(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCPMWorkItemProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
