package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecificationSummary;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface ProductSpecificationSummaryListViewRenderTemplate extends XTemplates {
  @XTemplate("<div><div style=\'float:left\'><span style=\'font-size:120%;font-weight:bold;\'>{value.productSpec.name}</span><BR> \u6761\u7801:{value.sid}</div> <div style=\'width:50px;float:right\'>{value.quantity}{value.unit}</div></div>")
  public abstract SafeHtml render(final UIProductSpecificationSummary value);
}
