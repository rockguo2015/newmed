package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureValueView;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdatePhasedElectricMeasureValueView.class)
public interface CreateOrUpdatePhasedElectricMeasureValuePresenterView extends FormViewer<UIPhasedElectricMeasureValue> {
}
