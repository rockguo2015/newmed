package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenterService")
public interface WorkItemTask4WorkersStatListPresenterService extends RemoteService {
  public abstract Collection<UIWorkItemTask4WorkersStatCriteriaData> load(final UIWorkItemTask4WorkersCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
