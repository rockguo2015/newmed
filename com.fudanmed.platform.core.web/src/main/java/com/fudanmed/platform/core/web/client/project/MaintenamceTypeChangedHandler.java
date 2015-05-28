package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.google.gwt.event.shared.EventHandler;

public interface MaintenamceTypeChangedHandler extends EventHandler {
  public abstract void MaintenamceTypeChanged(final RCMaintenamceTypeProxy org);
}
