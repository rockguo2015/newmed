package com.fudanmed.platform.core.web.client.project

import com.sencha.gxt.widget.core.client.grid.SummaryRenderer
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData
import com.sencha.gxt.core.client.ValueProvider
import java.util.Map
import com.google.gwt.safehtml.shared.SafeHtmlUtils

class WorkItemStockRecordSumRender implements SummaryRenderer<UIWorkItemStockRecordStatisticsData> {
	

	override render(Number value, Map<ValueProvider<? super UIWorkItemStockRecordStatisticsData,? extends Object>,Number> data) {
		if(value!=null)
			SafeHtmlUtils::fromTrustedString(value.toString()+"元")
		else 
			SafeHtmlUtils::fromTrustedString("");
	}
	
}