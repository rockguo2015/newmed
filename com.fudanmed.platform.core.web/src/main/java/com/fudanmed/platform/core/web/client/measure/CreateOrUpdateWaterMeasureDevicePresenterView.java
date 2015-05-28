package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDeviceView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateWaterMeasureDeviceView.class)
public interface CreateOrUpdateWaterMeasureDevicePresenterView extends FormViewer<UIWaterMeasureDevice> {
}
