package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.EBoardResult;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.EBoardPresenterService")
public interface EBoardPresenterService extends RemoteService {
  public abstract Integer loadRefreshInterval() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract EBoardResult loadActiveTasks(final Integer requestPage) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
