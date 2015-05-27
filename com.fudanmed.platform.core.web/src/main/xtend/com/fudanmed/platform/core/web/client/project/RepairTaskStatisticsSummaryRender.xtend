package com.fudanmed.platform.core.web.client.project

import com.sencha.gxt.widget.core.client.grid.SummaryRenderer
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData
import com.sencha.gxt.core.client.ValueProvider
import java.util.Map
import com.google.gwt.safehtml.shared.SafeHtmlUtils

class RepairTaskStatisticsSummaryRender implements SummaryRenderer<UIRepairTaskStatisticData> {

	override render(Number value, Map<ValueProvider<? super UIRepairTaskStatisticData,? extends Object>,Number> data) {
		if(value!=null)
			SafeHtmlUtils::fromTrustedString(value.toString())
		else SafeHtmlUtils::fromTrustedString("")
	}
	
}