package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.project.ExportRepairTaskStatisticDataCommandService")
public interface ExportRepairTaskStatisticDataCommandService extends RemoteService {
  public abstract String prepareExport(final UIRepairTaskStatisticCriteria pagedCriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
