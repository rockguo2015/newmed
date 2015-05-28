package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.google.gwt.event.shared.EventHandler;

public interface MaintenamceTypeDeletedHandler extends EventHandler {
  public abstract void MaintenamceTypeDeleted(final RCMaintenamceTypeProxy org);
}
