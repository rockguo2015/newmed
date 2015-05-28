package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluatePresenterService")
public interface CreateOrUpdateRepairEvaluatePresenterService extends RemoteService {
  public abstract UIRepairEvaluate loadValue(final RCRepairEvaluateProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIRepairEvaluate uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
