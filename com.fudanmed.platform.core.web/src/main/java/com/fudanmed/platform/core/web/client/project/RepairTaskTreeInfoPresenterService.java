package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIGeneralTask;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenterService")
public interface RepairTaskTreeInfoPresenterService extends RemoteService {
  public abstract Collection<UIGeneralTask> loadTree(final RCRepairTaskProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract String loadComment(final UIGeneralTask generalTask) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
