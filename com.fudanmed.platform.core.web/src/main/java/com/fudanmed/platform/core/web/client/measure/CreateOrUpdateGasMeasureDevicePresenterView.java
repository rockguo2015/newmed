package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDeviceView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateGasMeasureDeviceView.class)
public interface CreateOrUpdateGasMeasureDevicePresenterView extends FormViewer<UIGasMeasureDevice> {
}
