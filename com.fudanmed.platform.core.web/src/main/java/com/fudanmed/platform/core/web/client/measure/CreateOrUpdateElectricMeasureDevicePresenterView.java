package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDeviceView;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateElectricMeasureDeviceView.class)
public interface CreateOrUpdateElectricMeasureDevicePresenterView extends FormViewer<UIElectricMeasureDevice> {
}
