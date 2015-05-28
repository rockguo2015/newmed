package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterService")
public interface ShowRepairEvaluatePresenterService extends RemoteService {
  public abstract UIRepairEvaluate loadEvaluate(final RCRepairTaskProxy repairTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
