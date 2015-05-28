package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverTaskFinishDataView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskFinishData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverTaskFinishDataView.class)
public interface CreateOrUpdateDeliverTaskFinishDataPresenterView extends FormViewer<UIDeliverTaskFinishData> {
}
