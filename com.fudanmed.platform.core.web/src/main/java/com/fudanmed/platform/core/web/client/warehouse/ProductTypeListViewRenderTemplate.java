package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface ProductTypeListViewRenderTemplate extends XTemplates {
  @XTemplate("<div style=\'float:left\'><span style=\'font-size:120%;font-weight:bold;\'>{ft.name}</span><BR></div>")
  public abstract SafeHtml render(final UIProductType ft);
}
