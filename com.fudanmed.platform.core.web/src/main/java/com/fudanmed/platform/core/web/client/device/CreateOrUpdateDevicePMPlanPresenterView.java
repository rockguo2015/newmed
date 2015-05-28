package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDevicePMPlanView.class)
public interface CreateOrUpdateDevicePMPlanPresenterView extends FormViewer<UIDevicePMPlan> {
}
