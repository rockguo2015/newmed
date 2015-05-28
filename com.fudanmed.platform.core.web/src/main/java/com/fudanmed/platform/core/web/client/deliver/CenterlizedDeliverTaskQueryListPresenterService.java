package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterService")
public interface CenterlizedDeliverTaskQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UICenterlizedDeliverTask> filter(final UICenterlizedDeliverTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
