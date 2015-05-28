package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface ProductWarehouseStorageListRenderTemplate extends XTemplates {
  @XTemplate("<div><div style=\'float:left\'><span style=\'font-size:120%;font-weight:bold;\'>{value.name}</span><BR> \u6761\u7801:{value.productSpecsSid},\u5165\u5E93\u6279\u53F7:{value.sid}</div> <div style=\'width:50px;float:right\'>{value.quantity}{value.unit}</div></div>")
  public abstract SafeHtml render(final UIProductWarehouseStorage value);
}
