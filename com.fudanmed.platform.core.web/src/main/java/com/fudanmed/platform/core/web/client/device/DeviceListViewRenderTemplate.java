package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface DeviceListViewRenderTemplate extends XTemplates {
  @XTemplate("<div>\n\t\t\t\t\t<div style=\'float:left\'>\n\t\t\t\t\t\t<span style=\'font-size:120%;font-weight:bold;\'>{device.sid}</span><BR> \n\t\t\t\t\t\t\u540D\u79F0:{device.name}\n\t\t\t\t\t</div> \n\t\t\t\t\t<div style=\'width:50px;float:right\'>{device.deviceType.name}</div>\n\t\t\t\t</div>")
  public abstract SafeHtml render(final UIDevice device);
}
