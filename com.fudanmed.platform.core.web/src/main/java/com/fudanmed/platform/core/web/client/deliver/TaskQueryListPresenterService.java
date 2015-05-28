package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenterService")
public interface TaskQueryListPresenterService extends RemoteService {
  public abstract IPagedResult<UITask> filter(final UITaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
