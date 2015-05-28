package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.fudanmed.platform.core.web.shared.project.UIEBoardMessage;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessagePresenterService")
public interface CreateOrUpdateEBoardMessagePresenterService extends RemoteService {
  public abstract UIEBoardMessage loadValue(final RCEBoardMessageProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIEBoardMessage uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
