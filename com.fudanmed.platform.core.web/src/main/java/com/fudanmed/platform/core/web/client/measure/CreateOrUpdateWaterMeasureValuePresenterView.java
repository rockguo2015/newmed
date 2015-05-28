package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValueView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateWaterMeasureValueView.class)
public interface CreateOrUpdateWaterMeasureValuePresenterView extends FormViewer<UIWaterMeasureValue> {
}
