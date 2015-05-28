package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportRepairTaskStatisticDataCommandServiceAsync {
  public abstract void prepareExport(final UIRepairTaskStatisticCriteria pagedCriteria, final AsyncCallback<String> callback);
}
