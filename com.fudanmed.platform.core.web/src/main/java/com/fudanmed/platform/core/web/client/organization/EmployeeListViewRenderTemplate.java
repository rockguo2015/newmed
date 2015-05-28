package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface EmployeeListViewRenderTemplate extends XTemplates {
  @XTemplate("<div>{value.name}</div>")
  public abstract SafeHtml render(final RCEmployeeProxy value);
}
