package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.google.gwt.event.shared.EventHandler;

public interface RepairTaskCreatedHandler extends EventHandler {
  public abstract void RepairTaskCreated(final RCRepairTaskProxy value);
}
