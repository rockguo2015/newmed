package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskCancelDispatchDataView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskCancelDispatchData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverTaskCancelDispatchDataView.class)
public interface CreateOrUpdateDeliverTaskCancelDispatchDataPresenterView extends FormViewer<UIDeliverTaskCancelDispatchData> {
}
