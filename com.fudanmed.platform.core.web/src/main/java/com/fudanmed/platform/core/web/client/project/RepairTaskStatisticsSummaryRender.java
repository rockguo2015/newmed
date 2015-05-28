package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.common.base.Objects;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.widget.core.client.grid.SummaryRenderer;
import java.util.Map;

@SuppressWarnings("all")
public class RepairTaskStatisticsSummaryRender implements SummaryRenderer<UIRepairTaskStatisticData> {
  public SafeHtml render(final Number value, final Map<ValueProvider<? super UIRepairTaskStatisticData,? extends Object>,Number> data) {
    SafeHtml _xifexpression = null;
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      String _string = value.toString();
      SafeHtml _fromTrustedString = SafeHtmlUtils.fromTrustedString(_string);
      _xifexpression = _fromTrustedString;
    } else {
      SafeHtml _fromTrustedString_1 = SafeHtmlUtils.fromTrustedString("");
      _xifexpression = _fromTrustedString_1;
    }
    return _xifexpression;
  }
}
