package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.UpdateEBoardMessageCommandService")
public interface UpdateEBoardMessageCommandService extends RemoteService {
  public abstract RCEBoardMessageProxy loadEBoardMessage() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
