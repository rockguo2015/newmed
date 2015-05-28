package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface ProductWarehouseStorageSummaryListViewRenderTemplate extends XTemplates {
  @XTemplate("<div>\n\t\t\t\t\t<div style=\'float:left\'><span style=\'font-size:120%;font-weight:bold;\'>{value.name}</span><BR> \u6761\u7801:{value.productSpecsSid} \u89C4\u683C:{value.typeDesc} \u54C1\u724C:{value.brand}</div> \n\t\t\t\t\t<div style=\'width:50px;float:right\'>{value.quantity}{value.unit}</div>\n\t\t\t\t</div>")
  public abstract SafeHtml render(final UIProductWarehouseStorageSummary value);
}
