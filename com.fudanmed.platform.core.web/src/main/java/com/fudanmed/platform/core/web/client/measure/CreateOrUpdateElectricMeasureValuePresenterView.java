package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureValueView;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureValue;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateElectricMeasureValueView.class)
public interface CreateOrUpdateElectricMeasureValuePresenterView extends FormViewer<UIElectricMeasureValue> {
}
