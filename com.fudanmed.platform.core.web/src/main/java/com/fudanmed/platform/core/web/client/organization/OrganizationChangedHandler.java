package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.event.shared.EventHandler;

public interface OrganizationChangedHandler extends EventHandler {
  public abstract void OrganizationChanged(final RCOrganizationProxy org);
}
