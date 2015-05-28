package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface ProductSpecificationListViewRenderTemplate extends XTemplates {
  @XTemplate("<div><div style=\'float:left\'><span style=\'font-size:120%;font-weight:bold;\'>{value.name}</span><BR><b>\u7269\u54C1\u7F16\u53F7</b>:{value.materialId}</div> <div style=\'width:120px;float:right\'>\u89C4\u683C:{value.typeDesc}<BR>\u54C1\u724C:{value.brandType}</div></div>")
  public abstract SafeHtml render(final UIProductSpecification value);
}
