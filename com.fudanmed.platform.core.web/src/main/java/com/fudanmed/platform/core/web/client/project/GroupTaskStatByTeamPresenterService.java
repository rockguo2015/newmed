package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenterService")
public interface GroupTaskStatByTeamPresenterService extends RemoteService {
  public abstract Collection<UIGroupTaskStatByTeamCriteriaData> loadResult(final UIGroupTaskCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
