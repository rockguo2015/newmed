package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.XTemplates.XTemplate;

public interface FaultTypeListViewRenderTemplate extends XTemplates {
  @XTemplate("<div><div style=\'float:left\'><span style=\'font-size:120%;font-weight:bold;\'>{ft.name}</span><BR>\u5DE5\u65F6:{ft.standardCostTime},\u7EE9\u6548:{ft.performanceWeight},\u98CE\u9669\u7B49\u7EA7:{ft.faultRiskLevel.name}</div> <div style=\'width:100px;float:right\'>{ft.teamName}</div></div>")
  public abstract SafeHtml render(final UIFaultType ft);
}
