package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDeviceView;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdatePhasedElectricMeasureDeviceView.class)
public interface CreateOrUpdatePhasedElectricMeasureDevicePresenterView extends FormViewer<UIPhasedElectricMeasureDevice> {
}
